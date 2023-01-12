package com.commandPattern.addressBook

import kotlin.random.Random

interface Command{
    fun execute(): Any
}

class AddContactCommand(

    private val contact: Contact
): Command{
    override fun execute() {
        Storage.addContact(contact)
    }

}
class DeleteContactCommand(
    private val query: String
): Command{
    override fun execute(): Any =
        Storage.deleteContact(query)


}
class EditContactCommand(
    private val oldContact: Contact,
    private val newContact: Contact
):Command{
    override fun execute() {
        Storage.editContact(oldContact, newContact)
    }


}

class SearchContactCommand(
    private val query: String
): Command{
    override fun execute(): Any =
        Storage.searchContacts(query)

}
class AddGroupCommand(
    private val group: Group
): Command{
    override fun execute() {
        Storage.groups[group.groupId] = group
    }


}
class DeleteGroupContact(
    private val group: Group
): Command {
    override fun execute() {
        Storage.groups.remove(group.groupId)
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
    val history: MutableList<Command> = mutableListOf()
){

    fun executeCommand(command: Command): Any {
        history.add(command)
        return command.execute()
    }

}

fun main() {
    val obj = AddressBook()
    val c1 = Contact(1,"Hamza","Malik",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("Vayana","PDPU"))
    val c2 = Contact(2,"Shivam","Chavda",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("Vayana","Navrachna")
    )
    val c3 = Contact(3,"Hamza","Khan",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf()
    )
    val c4 = Contact(4,"Parth","Raval",
        mutableMapOf("work" to "parthwork@gmail.com","home" to "parthhome@gmail.com"),
        mutableMapOf("work" to "+91 789","home" to "+91 765"),
        mutableMapOf("HOME" to "BV","WORK" to "BRC"),
        mutableListOf("Vayana","PDPU")
    )
    obj.executeCommand(AddContactCommand(c1))
    obj.executeCommand(AddContactCommand(c2))
    obj.executeCommand(AddContactCommand(c3))
    obj.executeCommand(AddContactCommand(c4))
//    println(obj.history)
    obj.executeCommand(DeleteContactCommand("Hamza"))
//    println(obj.history)

    obj.executeCommand(EditContactCommand(c3, Contact(
        3,"Zayn","Malik",
        mutableMapOf("work" to "work1@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 125","home" to "+91 235"),
        mutableMapOf("HOME" to "ST","WORK" to "DL"),
        mutableListOf("One Direction","PDPU")))
    )
    println(obj.history)

    for(contact in Storage.contacts){
        println(contact)
    }
    val searched = obj.executeCommand(SearchContactCommand("hamza"))
    println(searched)
    println(obj.history)


    val g1 = Group(1,"Interns", mutableListOf(c1,c2,c4))


//    print()
}




















//    fun addContact(contact: Contact) {
////        contacts.add(contact)
//        val addCommand = AddContactCommand(contact, contacts)
//        addCommand.execute()
//    }