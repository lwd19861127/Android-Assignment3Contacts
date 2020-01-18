package com.derrick.park.assignment3_contacts.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.derrick.park.assignment3_contacts.databinding.ContactsListItemBinding
import com.derrick.park.assignment3_contacts.models.Contact


class ContactClickListener(val clickListener: (contact: Contact) -> Unit) {
    fun onClick(item: Contact) = clickListener(item)
}

class ContactsListAdapter()://val clickListener: ContactClickListener
        ListAdapter<Contact, ContactsListAdapter.ContactViewHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ContactsListItemBinding.inflate(layoutInflater,
                parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))//, clickListener
    }

    // ViewHolder
    class ContactViewHolder (val binding: ContactsListItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Contact) {//, clickListener: ContactClickListener
            //binding.contactClickListener = clickListener
            binding.nameTextView.text = item.name.toString()
            binding.dataTextView.text = item.cell
        }
    }
}

class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {

    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.cell == newItem.cell
    }
}
