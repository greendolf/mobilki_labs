package com.example.mydialer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {
    private val _contacts = MutableStateFlow(listOf<Contact>())
    private val _filteredContacts = MutableStateFlow(listOf<Contact>())
    val contacts: StateFlow<List<Contact>> = _contacts.asStateFlow()
    val filteredContacts: StateFlow<List<Contact>> = _filteredContacts.asStateFlow()

    init {
        viewModelScope.launch {
            val response = Transport.getContacts()
            saveResponse(response)
        }
    }

    private fun saveResponse(new: List<Contact>) {
        _contacts.update { new }
    }

    fun filterContacts(text: String) {
        val contacts = _contacts.value
        if (text == "") {
            _filteredContacts.update { contacts }
            return
        }

        _filteredContacts.update {
            contacts.filter {
                it.phone.contains(text) || it.type.contains(text) || it.name.contains(text)
            }
        }
    }
}
