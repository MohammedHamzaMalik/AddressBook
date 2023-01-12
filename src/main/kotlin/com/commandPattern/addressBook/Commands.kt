package com.commandPattern.addressBook

import java.util.UUID

interface Command{
    fun execute(): Any
}

class AddContactCommand(
    private val requests: AddContactRequest
): Command{
    override fun execute(): Any = Storage.addContact(requests.toContact())
}

class DeleteContactCommand(
    private val contactId: UUID
//    private val query: String
): Command {
    override fun execute(): Any = Storage.deleteContact(contactId)
}

class EditContactCommand(
    private val contactId: UUID,
    private val requests: EditContactRequest
): Command {
    override fun execute(): Any = Storage.editContact(contactId, requests.toContact())
}

class SearchContactCommand(
    private val query: String
): Command{
    override fun execute(): Any = Storage.searchContacts(query)

}