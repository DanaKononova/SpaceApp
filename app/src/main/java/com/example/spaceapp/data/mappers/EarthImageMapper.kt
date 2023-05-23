package com.example.spaceapp.data.mappers

import com.example.spaceapp.data.models.EarthImagesResponse
import com.example.spaceapp.domain.models.EarthImage
import javax.inject.Inject

class EarthImageMapper @Inject constructor(){
    operator fun invoke(earthImagesResponse: EarthImagesResponse) =
        EarthImage(
            image = earthImagesResponse.image ?: ""
        )
}