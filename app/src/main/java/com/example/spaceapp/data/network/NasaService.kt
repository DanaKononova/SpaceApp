package com.example.spaceapp.data.network

import com.example.spaceapp.data.models.DayPictureResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {
    @GET("/planetary/apod")
    suspend fun getDayPicture(
        @Query("api_key") token: String
    ): DayPictureResponse
}