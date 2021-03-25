package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import utils.Utils;

@Getter
public class CreateGroupRequest {
    private String grpName;

    private String description;

    private Long userId;

    public static String validationError;

    public static CreateGroupRequest build(JsonNode jsonNode) {
        return (CreateGroupRequest) Utils.converObjectTORequest(jsonNode, CreateGroupRequest.class);
    }

    public boolean validate(CreateGroupRequest createGroupRequest) {
        Boolean isValid = Boolean.TRUE;
        if(createGroupRequest.getGrpName() == null) {
            validationError = "userName is mandatory";
            isValid = Boolean.FALSE;
        }
        else if(createGroupRequest.getDescription() == null) {
            validationError = "Description field is mandatory";
            isValid = Boolean.FALSE;
        } else if (createGroupRequest.getUserId() == null) {
            validationError = " User Id Field is mandatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}
