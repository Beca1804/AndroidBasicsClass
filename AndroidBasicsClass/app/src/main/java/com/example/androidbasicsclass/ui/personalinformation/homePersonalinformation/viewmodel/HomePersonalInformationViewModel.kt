package com.example.androidbasicsclass.ui.personalinformation.homePersonalinformation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidbasicsclass.ui.personalinformation.homePersonalinformation.model.HomePersonalInformationModel

/**
 * ViewModel for the Personal Information home screen.
 * Holds and exposes UI state via [HomePersonalInformationModel] to [HomePersonalInformationView].
 */
class HomePersonalInformationViewModel : ViewModel() {
    val homeModel = HomePersonalInformationModel()
}
