package com.commandPattern.addressBook

import java.util.UUID

object Storage {
    private val contacts: MutableMap<UUID, Contact> = mutableMapOf()
    private val groups: MutableMap<UUID, Group> = mutableMapOf()
    fun addContact(contact: Contact): Contact{
        contacts[contact.contactId]=contact
        contact.groups.forEach { groupName ->
            val group = groups.values.find { it.groupName==groupName }
            if(group!=null){
                group.groupMembers.add(contact)
                groups[group.groupId]=group
            } else {
                val newGroup=Group(UUID.randomUUID(),groupName, mutableListOf(contact))
                groups[newGroup.groupId]=newGroup
            }
        }
        return contact
    }
    fun deleteContact(contactId: UUID): MutableMap<UUID, Contact> {
        contacts.remove(contactId)
        return contacts
    }
    fun editContact(contactId: UUID, contact: Contact): Contact {
        contacts[contactId]=contact
        return contact
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

    fun showContacts(): MutableMap<UUID, Contact>{
        return contacts
    }

    fun addGroup(group: Group): Group{
        groups[group.groupId]=group
        group.groupMembers.forEach{
            val contact = contacts[it.contactId]
            if(contact!=null){
                contact.groups.add(group.groupName)
                contacts[it.contactId]=contact
            }
        }
        return group
    }
    fun deleteGroup(groupId: UUID): MutableMap<UUID, Group> {
        groups.remove(groupId)
        return groups
    }
    fun showGroups(): MutableMap<UUID, Group> {
        return groups
    }
    fun editGroup(groupId: UUID, group: Group): Group {
        groups[groupId]=group
        return group
    }
    fun searchGroups(query: String): Map<UUID, Group> {
        return groups.filter {
            it.value.groupName.contains(query,ignoreCase = true)
        }
    }
}