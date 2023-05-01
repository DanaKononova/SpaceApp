package com.example.spaceapp.domain

import com.example.spaceapp.domain.models.DayPictureData

interface Repository {
    suspend fun getPictureOfDay(): DayPictureData

    fun setToken(token: String)
}