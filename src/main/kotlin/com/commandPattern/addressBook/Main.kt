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
            mutableListOf("Vayana")
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


    println("------------------------Contacts---------------------------")
//    var allContacts = obj.executeCommand(ShowContactCommand()) as Map<UUID, Contact>
//    allContacts.forEach {
//        println(it.value)
//    }
    for (contact in Storage.showContacts().values) {
        println("Contact Id: ${contact.contactId}")
        println("First Name: ${contact.firstName}")
        println("Last Name: ${contact.lastName}")
        println("Emails: ${contact.emails}")
        println("Phone Numbers: ${contact.phoneNumbers}")
        println("Addresses: ${contact.addresses}")
        println("Groups: ${contact.groups}\n")
    }
    println()


    println("------------------------Contact Deleted | Showing Remaining Contacts--------------------------")
    obj.executeCommand(DeleteContactCommand(hamza.contactId))
//    allContacts.forEach {
//        println(it.value)
//    }
    for (contact in Storage.showContacts().values) {
        println("Contact Id: ${contact.contactId}")
        println("First Name: ${contact.firstName}")
        println("Last Name: ${contact.lastName}")
        println("Emails: ${contact.emails}")
        println("Phone Numbers: ${contact.phoneNumbers}")
        println("Addresses: ${contact.addresses}")
        println("Groups: ${contact.groups}\n")
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
                        mutableListOf("One Direction","PDPU")))
    ) as Contact
//    println(editedObject)
//    for (contact in Storage.showContacts().values) {
    println("Contact Id: ${editedObject.contactId}")
    println("First Name: ${editedObject.firstName}")
    println("Last Name: ${editedObject.lastName}")
    println("Emails: ${editedObject.emails}")
    println("Phone Numbers: ${editedObject.phoneNumbers}")
    println("Addresses: ${editedObject.addresses}")
    println("Groups: ${editedObject.groups}\n")
//    }
    println()


    println("---------------------------Searching Contact------------------------")
    val searched = obj.executeCommand(SearchContactCommand("parth")) as Map<*,*>
    for(c in searched.values) println(c)
//    println(searched)
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


    println("----------------------------Groups----------------------------")
//    var allGroups = obj.executeCommand(ShowGroupsCommand()) as Map<UUID, Group>
//    allGroups.forEach {
//        println(it.value)
//    }
    for (group in Storage.showGroups().values) {
        println("Group Id: ${group.groupId}")
        println("Group Name: ${group.groupName}")
        println("Group Members: ${group.groupMembers}\n")
    }
    println()


    println("------------------------Group Deleted | Showing Remaining Groups--------------------------")
//    allGroups.forEach {
//        println(it.value)
//    }
    obj.executeCommand(DeleteGroupContact(people.groupId))
    for (group in Storage.showGroups().values) {
        println("Group Id: ${group.groupId}")
        println("Group Name: ${group.groupName}")
        println("Group Members: ${group.groupMembers}\n")
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
    val searchedGroup = obj.executeCommand(SearchGroupCommand("vayana")) as Map<*,*>
    for(c in searchedGroup.values) println(c)
//    println(searchedGroup)
    println()

//    allGroups.forEach {
//        println(it.value)
//    }
    for (group in Storage.showGroups().values) {
        println("Group Id: ${group.groupId}")
        println("Group Name: ${group.groupName}")
        println("Group Members: ${group.groupMembers}\n")
    }
    println()
    println("--------------------------History of Commands Used----------------------------")
    println(obj.history.joinToString("\n"))
}