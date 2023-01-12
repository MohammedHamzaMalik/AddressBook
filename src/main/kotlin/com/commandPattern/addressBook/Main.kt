package com.commandPattern.addressBook

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

    val hamza = obj.executeCommand(AddContactCommand(AddContactRequest(
        "Hamza","Malik",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("Vayana","PDPU")
    ))) as Contact

    val zayn = obj.executeCommand(AddContactCommand(
        AddContactRequest("Hamza","Khan",
            mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
            mutableMapOf("work" to "+91 123","home" to "+91 234"),
            mutableMapOf("HOME" to "ST","WORK" to "BRC"),
            mutableListOf()
        ))) as Contact

    val shivam = obj.executeCommand(AddContactCommand(AddContactRequest("Shivam","Chavda",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("Vayana","Navrachna")
    )))

    val parth = obj.executeCommand(AddContactCommand(AddContactRequest("Parth","Raval",
        mutableMapOf("work" to "parthwork@gmail.com","home" to "parthhome@gmail.com"),
        mutableMapOf("work" to "+91 789","home" to "+91 765"),
        mutableMapOf("HOME" to "BV","WORK" to "BRC"),
        mutableListOf("Vayana","PDPU")
    ))) as Contact
//    println(obj.history)
    obj.executeCommand(DeleteContactCommand(hamza.contactId))
//    println(obj.history)

    obj.executeCommand(EditContactCommand(
        zayn.contactId,
        EditContactRequest(zayn.contactId,
                        "Zayn",
                        "Malik",
                        zayn.emails,
                        zayn.phoneNumbers,
                        zayn.addresses,
                        mutableListOf("One Direction")))
    )
    println(obj.history)

    for(contact in Storage.contacts){
        println(contact)
    }
    val searched = obj.executeCommand(SearchContactCommand("hamza"))
//    println(searched)
//    println(obj.history)


//    val g1 = Group(1,"Interns", mutableListOf(hamza,zayn,parth))
    for(group in Storage.groups){
        println(group)
    }

//    print()
}




















//    fun addContact(contact: Contact) {
////        contacts.add(contact)
//        val addCommand = AddContactCommand(contact, contacts)
//        addCommand.execute()
//    }