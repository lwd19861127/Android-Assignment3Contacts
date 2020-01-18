package com.derrick.park.assignment3_contacts.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ContactList {
    @SerializedName("results")
    @Expose
    val contactList: MutableList<Contact>? = null
}