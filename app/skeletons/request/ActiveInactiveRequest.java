package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import utils.Utils;

@Getter
public class ActiveInactiveRequest {

    private Long userId;

    public static String validateStr;
    public static ActiveInactiveRequest build(JsonNode jsonNode) {
        return (ActiveInactiveRequest) Utils.converObjectTORequest(jsonNode,ActiveInactiveRequest.class);
    }

    public Boolean validate(ActiveInactiveRequest activeInactiveRequest) {
        Boolean isValid = Boolean.TRUE;
        if (activeInactiveRequest == null || activeInactiveRequest.getUserId() == null) {
            validateStr = "Invalid Request!!";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}
