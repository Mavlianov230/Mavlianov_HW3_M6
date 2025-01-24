package com.example.mavlianov_hw3_m6.ui.theme.Data.Api

import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.LocationsResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchAllLocations(): Response<LocationsResultsResponse>
}
