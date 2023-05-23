package com.example.spaceapp.domain

import com.example.spaceapp.domain.models.DateData
import com.example.spaceapp.domain.models.DayPictureData
import com.example.spaceapp.domain.models.EarthImage

interface Repository {
    suspend fun getPictureOfDay(): DayPictureData

    suspend fun getDates(): List<DateData>

    suspend fun getImageName(date: String): EarthImage

    fun setToken(token: String)
}