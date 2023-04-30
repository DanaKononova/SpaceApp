package com.example.spaceapp.data.mappers

import com.example.spaceapp.data.models.DayPictureResponse
import com.example.spaceapp.domain.models.DayPictureData
import javax.inject.Inject

class DayResponseMapper @Inject constructor() {
    operator fun invoke(dayPictureResponse: DayPictureResponse) =
        with(dayPictureResponse) {
            DayPictureData(
                data = data ?: "",
                explanation = explanation ?: "",
                title = title ?: "",
                url = url ?: ""
            )
        }
}