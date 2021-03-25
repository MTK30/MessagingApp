package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class AddContactRequest {

    private String contactsId;

    private Long userId;

    public static String validationError;

    public static AddContactRequest build(JsonNode jsonNode) {
        return (AddContactRequest) Utils.converObjectTORequest(jsonNode,AddContactRequest.class);
    }

    public static Boolean validate(AddContactRequest addContactRequest) {
        Boolean isValid = Boolean.TRUE;
        if(addContactRequest == null) {
            validationError = "userName is mandatory";
            isValid = Boolean.FALSE;
        } else if(addContactRequest.getContactsId() == null) {
            validationError = "Contact Id is mandatory";
            isValid = Boolean.TRUE;
        } else if(addContactRequest.getUserId() == null) {
            validationError = "UserId is mandatory";
            isValid = Boolean.TRUE;
        }
        return isValid;
    }
}
