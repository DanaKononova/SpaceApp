package com.example.spaceapp.data.models

import com.squareup.moshi.Json

data class EarthImagesResponse (
    @Json(name ="image") val image: String? = null
)