fun main(args: Array<String>) {
    val obj = AddressBookOperations()
    val c1 = Contact(1,"Hamza","Malik",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("A","B","C")
    )
    val c2 = Contact(2,"Shivam","Chavda",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("A","B","C")
    )
    val c3 = Contact(3,"Hamza","Khan",
        mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 123","home" to "+91 234"),
        mutableMapOf("HOME" to "ST","WORK" to "BRC"),
        mutableListOf("A","B")
    )
    val c4 = Contact(4,"Parth","Raval",
        mutableMapOf("work" to "parthwork@gmail.com","home" to "parthhome@gmail.com"),
        mutableMapOf("work" to "+91 789","home" to "+91 765"),
        mutableMapOf("HOME" to "BV","WORK" to "BRC"),
        mutableListOf("A","B")
    )
    obj.addContact(c1)
    obj.addContact(c2)
    obj.addContact(c3)
    obj.addContact(c4)
//    obj.deleteContact(c1)


    obj.editContact(Contact(3,"Zayn","Malik",
        mutableMapOf("work" to "work1@gmail.com","home" to "home@gmail.com"),
        mutableMapOf("work" to "+91 125","home" to "+91 235"),
        mutableMapOf("HOME" to "ST","WORK" to "DL"),
        mutableListOf("A","B","D")
    ))
    val searched = obj.searchContacts("work@gmail.com")
//    println(searched)
    for(c in searched)  println(c)
//    println(obj.contacts.joinToString("\n"))

    val g1 = Group(1,
        "Group1",
        mutableListOf(c1,c2,c3)
//        mutableListOf()
    )
    val g2 = Group(2,
        "Group2",
        mutableListOf(c2,c3)
//        mutableListOf()
    )
    obj.addGroup(g1)
    obj.addGroup(g2)
//    obj.deleteGroup(g1)
//    println(obj.groups.joinToString("\n"))
    obj.editGroup(
        Group(1,"Vayana Group", mutableListOf(c3,c4))
    )
    val searchedGroup = obj.searchGroups("Group")
    for(c in searchedGroup)  println(c)
}