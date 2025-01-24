package com.example.mavlianov_hw3_m6.ui.theme.ServiceLocator

import com.example.mavlianov_hw3_m6.ui.theme.App.ViewModel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(get()) }
}