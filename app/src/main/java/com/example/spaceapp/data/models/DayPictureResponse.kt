package com.example.spaceapp.data.models

import com.squareup.moshi.Json

data class DayPictureResponse(
    @Json(name = "date") val data: String? = null,
    @Json(name = "explanation") val explanation: String? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "url") val url: String? = null,
)