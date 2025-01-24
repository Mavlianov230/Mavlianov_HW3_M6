package com.example.mavlianov_hw3_m6.ui.theme.Data.Repository

import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.LocationApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.LocationsResponse

class LocationRepository(
    private val apiService: LocationApiService
) {

    suspend fun fetchAllLocations(): List<LocationsResponse>? {
        val response = apiService.fetchAllLocations()
        return if (response.isSuccessful) {
            response.body()?.locationsResponse
        } else {
            emptyList()
        }
    }
}
