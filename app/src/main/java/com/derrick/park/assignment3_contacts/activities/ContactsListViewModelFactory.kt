package com.derrick.park.assignment3_contacts.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactsListViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsListViewModel::class.java)) {
            return ContactsListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}