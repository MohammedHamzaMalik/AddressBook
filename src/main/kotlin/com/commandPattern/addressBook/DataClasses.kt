package com.commandPattern.addressBook

data class Contact(
    val contactId: Int,
    val firstName: String,
    val lastName: String,
    val emails: MutableMap<String, String>,
    val phoneNumbers: MutableMap<String, String>,
    val addresses: MutableMap<String, String>,
    val groups: MutableList<String>
)

data class Group(
    val groupId: Int,
    val groupName: String,
    val groupMembers: MutableList<Contact>
)