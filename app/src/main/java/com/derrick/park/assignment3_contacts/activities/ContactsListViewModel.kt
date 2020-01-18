package com.derrick.park.assignment3_contacts.activities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.derrick.park.assignment3_contacts.models.Contact
import com.derrick.park.assignment3_contacts.models.ContactList
import com.derrick.park.assignment3_contacts.network.ContactClient
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsListViewModel: ViewModel() {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var contacts: ContactList? = null

    private val _mContactList = MutableLiveData<ContactList>()
    val mContactList: LiveData<ContactList>
        get() = _mContactList

    init {
        initialize()

    }

    private fun initialize() {
        uiScope.launch {
            contacts = connectAPI()
            _mContactList.value = contacts
        }
    }

    private suspend fun connectAPI(): ContactList? {
        return withContext(Dispatchers.IO) {
            val call = ContactClient.getContacts(10)
            call.enqueue(object : Callback<ContactList> {
                override fun onResponse(call: Call<ContactList>, response: Response<ContactList>) {
                    if (response.isSuccessful) {
                        contacts = response.body()
                        for (contact in contacts!!.contactList!!) {
                            Log.i(MainActivity.TAG, "onResponse: " + contacts)
                            Log.i(MainActivity.TAG, "onResponse: $contact")
                        }
                    }
                }

                override fun onFailure(call: Call<ContactList>, t: Throwable) {
                    // Error Handling
                    Log.i(MainActivity.TAG, "onResponse: Failure")
                }
            })
            contacts
        }
    }
}