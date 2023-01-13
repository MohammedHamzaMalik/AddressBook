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
    override fun execute(): Any =
//        val newGroupIds = requests.groups.map { groupName ->
//            val group = Storage.groups.values.firstOrNull { it.groupName == groupName }
//        }
        Storage.editContact(contactId, requests.toContact())
}

class SearchContactCommand(
    private val query: String
): Command{
    override fun execute(): Any = Storage.searchContacts(query)

}

class ShowContactCommand: Command {
    override fun execute(): Any = Storage.showContacts()
}

class AddGroupCommand(
    private val request: AddGroupRequest
): Command{
    override fun execute(): Any = Storage.addGroup(request.toGroup())
}

class DeleteGroupContact(
    private val groupId: UUID
): Command {
    override fun execute(): Any = Storage.deleteGroup(groupId)

}

class ShowGroupsCommand: Command{
    override fun execute(): Any = Storage.showGroups()

}
class EditGroupCommand(
    private val groupId:UUID,
    private val request: EditGroupRequest
): Command{
    override fun execute(): Any = Storage.editGroup(groupId,request.toGroup())
}
class SearchGroupCommand(
    private val query: String
): Command{
    override fun execute(): Any = Storage.searchGroups(query)
}