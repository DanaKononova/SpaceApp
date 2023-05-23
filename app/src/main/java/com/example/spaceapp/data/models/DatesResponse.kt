package com.example.spaceapp.data.models

import com.squareup.moshi.Json

data class DatesResponse(
    @Json(name = "date") val data: String? = null,
)