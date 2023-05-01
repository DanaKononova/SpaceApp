package com.example.spaceapp.domain

import com.example.spaceapp.domain.models.DateData
import com.example.spaceapp.domain.models.DayPictureData

interface Repository {
    suspend fun getPictureOfDay(): DayPictureData

    suspend fun getDates(): List<DateData>

    fun setToken(token: String)
}