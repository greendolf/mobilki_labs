package com.example.gson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber


class MyViewModel : ViewModel() {
    private val _links = MutableStateFlow(listOf<String>())
    val links: StateFlow<List<String>> = _links.asStateFlow()

    init {
        viewModelScope.launch {
            val response = Transport.getImagePage()
            saveResponse(response)
        }
    }

    private fun saveResponse(new: Wrapper) {
        new.photos.photo.forEachIndexed { index, photo ->
            if ((index + 1) % 5 == 0) Timber.tag("API").i(photo.toString())
        }

        _links.update {
            new.photos.photo.map {
                "https://farm${it.farm}.staticflickr.com/${it.server}/${it.id}_${it.secret}_z.jpg"
            }
        }
    }
}
