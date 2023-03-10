import com.commandPattern.addressBook.*
import java.util.*

object TestUtils {
    private fun getContact(): Contact {
        return Contact(
            UUID.randomUUID(),
            "Hamza","Malik",
            mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
            mutableMapOf("work" to "+91 123","home" to "+91 234"),
            mutableMapOf("HOME" to "ST","WORK" to "BRC"),
            mutableListOf("Vayana","PDPU")
        )
    }
    fun getGroup(): Group {
        return Group(
            UUID.randomUUID(),
            "Friends",
            mutableListOf(getContact())
        )
    }
    fun getAddContactRequest(): AddContactRequest {
        return AddContactRequest(
            "Hamza","Malik",
            mutableMapOf("work" to "work@gmail.com","home" to "home@gmail.com"),
            mutableMapOf("work" to "+91 123","home" to "+91 234"),
            mutableMapOf("HOME" to "ST","WORK" to "BRC"),
            mutableListOf("Vayana","PDPU")
        )
    }
//    fun getDeleteContactCommand(contactId: UUID): DeleteContactCommand {
//        return DeleteContactCommand(getContact().contactId)
//    }

    fun getEditContactRequest(): EditContactRequest {
        return EditContactRequest(
            UUID.randomUUID(),
            "John",
            "Doe",
            mutableMapOf("Personal" to "per@gmail.com", "Work" to "w@gmail.com"),
            mutableMapOf("Personal" to "1234567890", "Work" to "0987654321"),
            mutableMapOf("Personal" to "123, abc street", "Work" to "456, xyz street"),
            mutableListOf("Friends", "Family")
        )
    }
    fun getSearchedContact(): String {
        return "Contact Searched"
    }

//    fun getAddGroupRequest(): AddGroupRequest {
//        return AddGroupRequest(
//            "Friends",
//            mutableListOf(getContact())
//        )
//    }
}