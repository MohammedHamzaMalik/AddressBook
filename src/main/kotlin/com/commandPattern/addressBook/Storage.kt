package com.commandPattern.addressBook

object Storage {
    val contacts: MutableMap<Int, Contact> = mutableMapOf()
    val groups = mutableMapOf<Int, Group>()
    fun addContact(contact: Contact): Contact{
        contacts[contact.contactId]=contact
        return contact
    }
    fun deleteContact(query: String): MutableMap<Int, Contact>{
        for(contact in contacts){
            if(contact.value.firstName==query || contact.value.lastName==query){
                contacts.remove(contact.key)
                break
            }
        }
        return contacts
    }
    fun editContact(oldContact: Contact, updatedContact: Contact) {
        for (i in contacts) {
            if (i.value.contactId==oldContact.contactId) {
                contacts[oldContact.contactId] = updatedContact
                break
            }
        }
    }
    fun searchContacts(query: String): Map<Int, Contact> {
        return contacts.filter {
            it.value.firstName.contains(query,ignoreCase = true) ||
                    it.value.lastName.contains(query,ignoreCase = true) ||
                    it.value.phoneNumbers.values.contains(query) ||
                    it.value.addresses.values.contains(query) ||
                    it.value.emails.values.contains(query) ||
                    it.value.groups.contains(query)
        }
    }
}