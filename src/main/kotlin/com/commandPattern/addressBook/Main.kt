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

interface Command{
    fun execute()
//    fun undo()
}
//val contacts = mutableListOf<Contact>()
val groups = mutableListOf<Group>()
class AddContactCommand(

    private val contact: Contact, private val contacts: MutableList<Contact>
): Command{
    override fun execute() {
        contacts.add(contact)
    }

}
class DeleteContactCommand(
    private val contact: Contact
): Command{
    override fun execute() {
//        contacts.remove(contact)
    }


}
class EditContactCommand(
    private val contact: Contact
):Command{
    override fun execute() {
//        for((key,value) in contacts.withIndex()){
//            if(value.contactId==contact.contactId){
//                contacts[key]=contact
//            }
//        }
    }


}

//class SearchContactCommand(
//    private val query: String
//): Command{
//    override fun execute(): List<Contact> {
//        return contacts.filter {
//            query.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } ||
//                    query.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } ||
//                    it.phoneNumbers.values.contains(query) ||
//                    it.addresses.values.contains(query) ||
//                    it.emails.values.contains(query)
//        }
//    }
//
//
//}
class AddGroupCommand(
    group: Group
): Command{
    override fun execute() {
        TODO("Not yet implemented")
    }


}
class DeleteGroupContact(
    group: Group
): Command {
    override fun execute() {
        TODO("Not yet implemented")
    }

}
class EditGroupCommand(
    group: Group
): Command{
    override fun execute() {
        TODO("Not yet implemented")
    }



}
class SearchGroupCommand(
    group: Group
): Command {
    override fun execute() {
        TODO("Not yet implemented")
    }


}

class AddressBook(
//    val history: MutableList<Command> = mutableListOf(),
){
    val contacts: MutableList<Contact> = mutableListOf()

//    fun executeCommand(command: Command) {
//        val list = command.execute()
//        return list
//    }

    fun addContact(contact: Contact) {
//        contacts.add(contact)
        val addCommand = AddContactCommand(contact, contacts)
        addCommand.execute()
    }
}

fun main() {
    val obj = AddressBook()
    val c1 = Contact(1,"Hamza","Malik",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("A","B","C"))
    obj.addContact(c1)
    print(obj.contacts)
//    println(contacts.joinToString("\n"))
}