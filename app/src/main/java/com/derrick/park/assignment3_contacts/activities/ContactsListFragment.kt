package com.derrick.park.assignment3_contacts.activities

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.derrick.park.assignment3_contacts.R
import com.derrick.park.assignment3_contacts.databinding.FragmentContactsListBinding

class ContactsListFragment : Fragment() {
    private lateinit var contactsListViewModel: ContactsListViewModel
    private lateinit var contactsListViewModelFactory: ContactsListViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding: FragmentContactsListBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contacts_list,
                container,
                false)

//        contactsListViewModelFactory = ContactsListViewModelFactory(
//                ContactsListFragmentArgs.fromBundle(arguments!!).contact)
        contactsListViewModel = ViewModelProviders.of(this)
                .get(ContactsListViewModel::class.java)
        binding.contactsListViewModel = contactsListViewModel

        val adapter = ContactsListAdapter()//ContactClickListener { contact -> }

        binding.contactsListRecyclerView.adapter = adapter

        contactsListViewModel.mContactList.observe(viewLifecycleOwner, Observer {contacts ->
            contacts?.let {
                adapter.submitList(it.contactList!!)
            }
        })

        binding.setLifecycleOwner(this)

        binding.contactsListRecyclerView.layoutManager = LinearLayoutManager(activity)

        this.setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu ,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
