package com.example.spaceapp.domain.models

data class DateData(
    val data: String,
) {
    override fun toString(): String {
        return data
    }

    fun toRequest(): List<String> {
        return data.split("-")
    }
}