package com.example.spaceapp.data.mappers

import com.example.spaceapp.data.models.DatesResponse
import com.example.spaceapp.domain.models.DateData
import javax.inject.Inject

class DatesResponseMapper @Inject constructor() {
    operator fun invoke(datesResponse: DatesResponse) =
        with(datesResponse) {
            DateData(
                data = data ?: ""
            )
        }
}