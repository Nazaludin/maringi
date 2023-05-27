package com.developer.myapplication.ui.profil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is setting Fragment"
    }
    val text: LiveData<String> = _text
}