package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class CreateUserRequest {
    private String name;
    private Long mobileNo;
    public static String validationError;

    public static CreateUserRequest build(JsonNode jsonNode) {
        return (CreateUserRequest) Utils.converObjectTORequest(jsonNode,CreateUserRequest.class);
    }

    public static Boolean validate(CreateUserRequest createUserRequest) {
        Boolean isValid = Boolean.TRUE;
        if(createUserRequest.name == null) {
            validationError = "userName is mandatory";
            isValid = Boolean.FALSE;
        }
        else if(createUserRequest.getMobileNo() == null) {
            validationError = "Mobile No Field is mandatory";
            isValid = Boolean.TRUE;
        }
        return isValid;
    }



}
