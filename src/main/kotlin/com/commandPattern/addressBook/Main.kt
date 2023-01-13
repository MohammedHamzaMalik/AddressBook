package com.commandPattern.addressBook

import java.util.UUID

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


    println("------------------------Contacts Added---------------------------")
    var allContacts = obj.executeCommand(ShowContactCommand()) as Map<UUID, Contact>
    allContacts.forEach {
        println(it.value)
    }
    println()


    println("------------------------Contact Deleted | Showing Remaining Contacts--------------------------")
    obj.executeCommand(DeleteContactCommand(hamza.contactId))
    allContacts.forEach {
        println(it.value)
    }
    println()


    println("------------------------Contact Edited----------------------------")
    val editedObject = obj.executeCommand(EditContactCommand(
        zayn.contactId,
        EditContactRequest(zayn.contactId,
                        "Zayn",
                        "Malik",
                        zayn.emails,
                        zayn.phoneNumbers,
                        zayn.addresses,
                        mutableListOf("One Direction")))
    )
    println(editedObject)
    println()


    println("---------------------------Searching Contact------------------------")
    val searched = obj.executeCommand(SearchContactCommand("parth"))
    println(searched)
    println()


    println("--------------------------History of Commands Used----------------------------")
    println(obj.history.joinToString("\n"))
    println()


    val vayana = obj.executeCommand(AddGroupCommand(
        AddGroupRequest(
        "Vayana Interns",
        mutableListOf(hamza,parth)
    ))) as Group
    val people = obj.executeCommand(AddGroupCommand(
        AddGroupRequest(
            "Peoples",
            mutableListOf(zayn,hamza,parth)
    ))) as Group


    println("----------------------------Group Added----------------------------")
    var allGroups = obj.executeCommand(ShowGroupsCommand()) as Map<UUID, Group>
    allGroups.forEach {
        println(it.value)
    }
    println()


    println("------------------------Group Deleted | Showing Remaining Groups--------------------------")
    allGroups.forEach {
        println(it.value)
    }
    println()


    println("------------------------Group Edited----------------------------")
    val editedGroup = obj.executeCommand(EditGroupCommand(
        vayana.groupId,
        EditGroupRequest(vayana.groupId,
            "Vayana Intern",
            mutableListOf(hamza,parth)
    )))
    println(editedGroup)
    println()


    println("---------------------------Searching Group------------------------")
    val searchedGroup = obj.executeCommand(SearchGroupCommand("vayana"))
    println(searchedGroup)
    println()

    allGroups.forEach {
        println(it.value)
    }
    println()
    println("--------------------------History of Commands Used----------------------------")
    println(obj.history.joinToString("\n"))
}