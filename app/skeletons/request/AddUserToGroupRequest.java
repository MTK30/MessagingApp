package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import utils.Utils;


@Getter
public class AddUserToGroupRequest {

    private Long groupId;

    private Long userId;

    private String candidateIds;

    public static String validateString;

    public static AddUserToGroupRequest build(JsonNode jsonNode) {
        return (AddUserToGroupRequest) Utils.converObjectTORequest(jsonNode, AddUserToGroupRequest.class);
    }

    public Boolean validate(AddUserToGroupRequest addUserToGroupRequest) {
        Boolean isValid = Boolean.TRUE;
        if(addUserToGroupRequest.getUserId() == null) {
            validateString = "userId of the person adding to gpp is madatory";
            isValid = Boolean.FALSE;
        } else if(addUserToGroupRequest.getCandidateIds() == null) {
            validateString = "candidateIds is madatory";
            isValid = Boolean.FALSE;
        } else if(addUserToGroupRequest.groupId == null) {
            validateString = "groupId is madatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}
