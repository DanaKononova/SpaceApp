package com.example.spaceapp.data.network

import com.example.spaceapp.data.models.DatesResponse
import com.example.spaceapp.data.models.DayPictureResponse
import com.example.spaceapp.data.models.EarthImagesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaService {
    @GET("/planetary/apod")
    suspend fun getDayPicture(
        @Query("api_key") token: String
    ): DayPictureResponse

    @GET("/EPIC/api/enhanced/all")
    suspend fun getDates(
        @Query("api_key") token: String
    ): List<DatesResponse>

    @GET("/EPIC/api/enhanced/date/{date}")
    suspend fun getImageName(
        @Path("date") date: String,
        @Query("api_key") token: String,
    ): List<EarthImagesResponse>
}