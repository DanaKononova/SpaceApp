package com.example.spaceapp.data

import com.example.spaceapp.data.mappers.DayResponseMapper
import com.example.spaceapp.data.network.NasaService
import com.example.spaceapp.data.source.PreferencesSource
import com.example.spaceapp.domain.Repository
import com.example.spaceapp.domain.models.DayPictureData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: NasaService,
    val dayResponseMapper: DayResponseMapper,
    private val source: PreferencesSource
): Repository{
    override suspend fun getPictureOfDay(
    ): DayPictureData {
        return withContext(Dispatchers.IO) {
            val response = service.getDayPicture(source.getUserToken())
            dayResponseMapper(response)
        }
    }

    override fun setToken(token: String) {
        source.setUserToken(token)
    }
}