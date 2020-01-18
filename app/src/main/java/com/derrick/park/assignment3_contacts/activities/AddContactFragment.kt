package com.derrick.park.assignment3_contacts.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.derrick.park.assignment3_contacts.R
import com.derrick.park.assignment3_contacts.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentAddContactBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_add_contact,
                container,
                false
        )
        return binding.root
    }
}
