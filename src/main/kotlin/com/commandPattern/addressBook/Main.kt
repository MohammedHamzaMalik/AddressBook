package com.commandPattern.addressBook


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
    ))) as Contact

    val parth = obj.executeCommand(AddContactCommand(AddContactRequest("Parth","Raval",
        mutableMapOf("work" to "parthwork@gmail.com","home" to "parthhome@gmail.com"),
        mutableMapOf("work" to "+91 789","home" to "+91 765"),
        mutableMapOf("HOME" to "BV","WORK" to "BRC"),
        mutableListOf("Vayana","PDPU")
    ))) as Contact


    println("------------------------Contacts---------------------------")
    val allContacts = obj.executeCommand(ShowContactCommand()) as Collection<Contact>
    for (contact in allContacts) {
        println("Contact Id: ${contact.contactId}")
        println("First Name: ${contact.firstName}")
        println("Last Name: ${contact.lastName}")
        println("Emails: ${contact.emails}")
        println("Phone Numbers: ${contact.phoneNumbers}")
        println("Addresses: ${contact.addresses}")
        println("Groups: ${contact.groups}\n")
    }


    println("------------------------Contact Deleted--------------------------")
    val deletedContact = obj.executeCommand(DeleteContactCommand(hamza.contactId))
    println(deletedContact)
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
    )
    println(editedObject)
    println()


    println("---------------------------Searched Contacts------------------------")
    val searchedContacts = obj.executeCommand(SearchContactCommand("PDPU")) as List<Contact>
    for (contact in searchedContacts) {
        println("Contact Id: ${contact.contactId}")
        println("First Name: ${contact.firstName}")
        println("Last Name: ${contact.lastName}")
        println("Emails: ${contact.emails}")
        println("Phone Numbers: ${contact.phoneNumbers}")
        println("Addresses: ${contact.addresses}")
        println("Groups: ${contact.groups}\n")
    }


    println("--------------------------History of Commands Used----------------------------")
    println(obj.history.joinToString("\n"))
    println()


    val vayana = obj.executeCommand(AddGroupCommand(
        AddGroupRequest(
        "Vayana Interns",
        mutableListOf(hamza,parth,shivam)
    ))) as Group
    val people = obj.executeCommand(AddGroupCommand(
        AddGroupRequest(
            "Peoples",
            mutableListOf(zayn,hamza,parth,shivam)
    ))) as Group


    println("----------------------------Groups----------------------------")
    val allGroups = obj.executeCommand(ShowGroupsCommand()) as Collection<Group>
    for (group in allGroups) {
        println("Group Id: ${group.groupId}")
        println("Group Name: ${group.groupName}")
        println("Group Members: ${group.groupMembers}\n")
    }
    println()


    println("------------------------Group Deleted--------------------------")
//    allGroups.forEach {
//        println(it.value)
//    }
    val deletedGroup = obj.executeCommand(DeleteGroupContact(people.groupId))
    println(deletedGroup)
    println()


    println("------------------------Group Edited----------------------------")
    val editedGroup = obj.executeCommand(EditGroupCommand(
        vayana.groupId,
        EditGroupRequest(vayana.groupId,
            "Vayana Intern",
            mutableListOf(zayn)
    )))
    println(editedGroup)
    println()


    println("---------------------------Searched Groups------------------------")
    val searchedGroup = obj.executeCommand(SearchGroupCommand("vayana")) as List<Group>
    for (group in searchedGroup) {
        println("Group Id: ${group.groupId}")
        println("Group Name: ${group.groupName}")
        println("Group Members: ${group.groupMembers}\n")
    }
    println("--------------------------History of Commands Used----------------------------")
    println(obj.history.joinToString("\n"))
}