package com.derrick.park.assignment3_contacts.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {
    @SerializedName("gender")
    @Expose
    val gender: String? = null
    @SerializedName("name")
    @Expose
    val name: Name? = null
    @SerializedName("location")
    @Expose
    val location: Location? = null
    @SerializedName("email")
    @Expose
    val email: String? = null
    @SerializedName("cell")
    @Expose
    val cell: String? = null

    override fun toString(): String {
        return String.format("%n%s%n%s%n%s%n%s", name, location, email, cell)
    }

    /**
     * Name {first: , last: }
     */
    inner class Name {
        @SerializedName("first")
        @Expose
        val first: String? = null
        @SerializedName("last")
        @Expose
        val last: String? = null

        override fun toString(): String {
            return "$first $last"
        }
    }

    /**
     * Location {street: , city: , state: , postcode: }
     */
    inner class Location {
//        @SerializedName("street")
//        @Expose
//        val street: String? = null
        @SerializedName("city")
        @Expose
        val city: String? = null
        @SerializedName("state")
        @Expose
        val province: String? = null
        @SerializedName("postcode")
        @Expose
        val postcode: String? = null

        override fun toString(): String {
            return "$city, $province Canada $postcode"
        }
    }
}