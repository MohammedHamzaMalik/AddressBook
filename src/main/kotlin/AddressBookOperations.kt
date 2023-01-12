class AddressBookOperations{
    val contacts = mutableListOf<Contact>()
//    val contacts = mutableMapOf<String, Contact>()
    val groups = mutableListOf<Group>()

    fun addContact(contact: Contact){
        contacts.add(contact)
//        contacts.put(contact.contactId,contact)
    }
    fun deleteContact(contact: Contact){
        contacts.remove(contact)
    }
    fun searchContacts(query: String): List<Contact> {
        return contacts.filter {
            query.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } ||
                    query.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } ||
                    it.phoneNumbers.values.contains(query) ||
                    it.address.values.contains(query) ||
                    it.emails.values.contains(query) ||
                    it.group.contains(query)
        }
//        var searchedContacts: MutableList<Contact> = mutableListOf()
//        for(i in contacts){
//            if(i.firstName.contains(query,ignoreCase = true)
//                || i.lastName.contains(query,ignoreCase = true)
//                || )
//        }


//        else if (phoneNumber == null && query != null)
//                return contacts.filter {
//                    query?.let { it1 -> it.firstName.contains(it1, ignoreCase = true) } == true ||
//                            query?.let { it1 -> it.lastName.contains(it1, ignoreCase = true) } == true
//        }
//        else if (phoneNumber != null && query == null)
//            return contacts.filter {
//                it.phoneNumbers.values.contains(phoneNumber)
//        }
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
//        group.groupContacts.contains()
    }
    fun deleteGroup(group: Group){
        groups.remove(group)

    }
    fun searchGroups(query: String): List<Group>{
        return groups.filter {
            it.groupId.equals(query)
            it.groupName.contains(query,ignoreCase = true)
//                it.groupContacts.contains()
        }
    }
    fun editGroup(group: Group): String{
        for((k,v) in contacts.withIndex()){
            if(v.contactId==group.groupId){
                groups[k]=group
                return "${group.groupName} edited"
            }
        }
        return "Not found"
    }
}