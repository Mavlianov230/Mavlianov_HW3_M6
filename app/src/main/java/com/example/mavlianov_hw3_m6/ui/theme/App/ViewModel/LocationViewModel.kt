package com.example.mavlianov_hw3_m6.ui.theme.App.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mavlianov_hw3_m6.ui.theme.Data.Repository.LocationRepository
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchAllLocations() {
        viewModelScope.launch {
            val locations = locationRepository.fetchAllLocations()
            Log.e("LocationViewModel", "Fetched Locations: $locations")
        }
    }
}
