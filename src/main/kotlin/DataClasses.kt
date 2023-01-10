data class Contact (
    val contactId: Int,
    val firstName: String,
    val lastName: String,
//    first_last = firstName + lastName

//    val emails: List<Email>,
    val emails: MutableMap<String, String>,

//    val phoneNumbers: List<PhoneNumber>,
    val phoneNumbers: MutableMap<String, String>,

//    val addresses: List<Address>,
    val address: MutableMap<String, String>,
    val group: MutableList<String>
)


//data class Email (
//    val typeOfEmail: String,
//    val emailAddress: String
//)
//data class PhoneNumber (
//    val typeOfNumbers: String,
//    val phoneNumber: String
//)
//data class Address (
//    val typeOfAddress: String,
//    val address: String
//)
//


data class Group (
    val groupId: Int,
    val groupName: String,
    val groupContacts: MutableList<Contact>
)