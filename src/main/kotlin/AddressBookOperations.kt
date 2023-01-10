class AddressBookOperations{
    val contacts = mutableListOf<Contact>()
    val groups = mutableListOf<Group>()

    fun addContact(contact: Contact){
        contacts.add(contact)
    }
    fun deleteContact(contact: Contact){
        contacts.remove(contact)
    }
    fun searchContacts(query: String): List<Contact> {
        if (query!=null) {
            return contacts.filter {
                query.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } ||
                        query.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } ||
                        it.phoneNumbers.values.contains(query) ||
                        it.address.values.contains(query) ||
                        it.emails.values.contains(query) ||
                        it.group.contains(query)
            }
        }
//        else if (phoneNumber == null && query != null)
//                return contacts.filter {
//                    query?.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } == true ||
//                            query?.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } == true
//        }
//        else if (phoneNumber != null && query == null)
//            return contacts.filter {
//                it.phoneNumbers.values.contains(phoneNumber)
//        }
        return TODO("Please enter a query")
    }
    fun editContact(contact: Contact): String{
        for((k,v) in contacts.withIndex()){
            if(v.contactId==contact.contactId){
                contacts[k]=contact
                return "${contact.firstName} edited"
            }
        }
        return "Not found"
    }

    fun addGroup(group: Group){
        groups.add(group)
    }
    fun deleteGroup(group: Group){
        groups.remove(group)
    }
    fun searchGroups(query: String): List<Group>{
        if (query!=null) {
            return groups.filter {
//                query.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } ||
//                        query.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } ||
//                        it.phoneNumbers.values.contains(query) ||
//                        it.address.values.contains(query) ||
//                        it.emails.values.contains(query) ||
//                        it.group.contains(query)
                it.groupId.equals(query)
                it.groupName.contains(query,ignoreCase = true)
//                it.groupContacts.contains()
            }
        }
        return TODO("WRITE A CORRECT QUERY")
    }
}