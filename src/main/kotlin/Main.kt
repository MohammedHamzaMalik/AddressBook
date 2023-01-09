data class Contact (val contactId: Int, val firstName: String, val lastName: String, val emails: List<Email>, val phoneNumbers: List<PhoneNumber>, val addresses: List<Address>, val group: MutableList<String>)

data class Email (val personalEmail: String?, val professionalEmail: String?)
data class PhoneNumber (val homeNumber: Int?, val workNumber: Int?)

data class Address (val homeAddress: String?, val workAddress: String?)

data class Group (val groupName: String, val groupContacts: MutableList<String>)

class AddressBookOperations{
    val contacts = mutableListOf<Contact>()
    val groups = mutableListOf<Group>()

    fun addContact(contact: Contact){
        contacts.add(contact)
    }
    fun deleteContact(contact: Contact){
        contacts.remove(contact)
    }
    fun searchContacts(contacts: List<Contact>, query: String): List<Contact> {
        return contacts.filter {
            it.firstName.contains(query, ignoreCase = true) ||
            it.lastName.contains(query, ignoreCase = true) ||
            it.phoneNumbers.toString().contains(query,ignoreCase = true)
//                it.phoneNumbers.homeNumber.toString().contains(query,ignoreCase = true)
        }
    }
    fun editContact(contact: Contact): String{
        for((k,v) in contacts.withIndex()){
            if(v.contactId==contact.contactId){
                contacts[k]=contact
                return "${contact.firstName} editted"
            }
        }
        return "Not found"
//        contacts[contacts.indexOf(contact)]=contact
    }
}
fun main(args: Array<String>) {
    val obj = AddressBookOperations()
    val c1 = Contact(1,"Hamza","Malik",
        mutableListOf(Email("ddw","dwd")),
        mutableListOf(PhoneNumber(1234,5678)),
        mutableListOf(Address("HOME","WORK")),
        mutableListOf("A","B","C")
    )
    val c2 = Contact(2,"Shivam","Chavda",
        mutableListOf(Email("shivam@g.com","shivamWork@g.com")),
        mutableListOf(PhoneNumber(9876,5432)),
        mutableListOf(Address("Shivam HOME","Shivam WORK")),
        mutableListOf("A","B","C")
    )
    val c3 = Contact(3,"Hamza","Khan",
        mutableListOf(Email("hamza@g.com","hamzaWork@g.com")),
        mutableListOf(PhoneNumber(1234,5678)),
        mutableListOf(Address("HOME","WORK")),
        mutableListOf("A","B","C")
    )
    obj.addContact(c1)
    obj.addContact(c2)
    obj.addContact(c3)
    obj.deleteContact(c1)
//    println(obj.contacts.joinToString("\n"))
    val searched = obj.searchContacts(obj.contacts, "5678")
//    println(searched)
    for(c in searched)  println(c)
    obj.editContact(Contact(3,"Zayn","Malik",
        mutableListOf(Email("hamza@g.com","hamzaWork@g.com")),
        mutableListOf(PhoneNumber(1234,5678)),
        mutableListOf(Address("HOME","WORK")),
        mutableListOf("A","B","C")
    ))
    println(obj.contacts)
}