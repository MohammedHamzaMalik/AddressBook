package com.commandPattern.addressBook

import java.util.UUID

object Storage {
    val contacts: MutableMap<UUID, Contact> = mutableMapOf()
    val groups: MutableMap<UUID, Group> = mutableMapOf()
    fun addContact(contact: Contact): Contact{
        contacts[contact.contactId]=contact
        return contact
    }
    fun deleteContact(contactId: UUID): MutableMap<UUID, Contact> {
        contacts.remove(contactId)
        return contacts
    }
    fun editContact(contactId: UUID, contact: Contact): Contact {
        contacts[contactId]=contact
        return contact
//        for (i in contacts) {
//            if (i.value.contactId==contact.contactId) {
//                contacts[i.value.contactId] = contact
//                break
//            }
//        }
    }
    fun searchContacts(query: String): Map<UUID, Contact> {
        return contacts.filter {
            it.value.firstName.contains(query,ignoreCase = true) ||
                    it.value.lastName.contains(query,ignoreCase = true) ||
                    it.value.phoneNumbers.values.contains(query) ||
                    it.value.addresses.values.contains(query) ||
                    it.value.emails.values.contains(query) ||
                    it.value.groups.contains(query)
        }
    }

//    fun addGroup(group: Group): Group{
//        group[group.groupId]=group
//        return group
//    }
}