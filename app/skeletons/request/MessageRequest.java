package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import utils.Utils;

@Getter
public class MessageRequest {

    private Long fromUserId;

    private Long receiversId;

    private String message;

    private Boolean isGroupId;

    public static String validationError;

    public static MessageRequest build(JsonNode jsonNode) {
        return (MessageRequest) Utils.converObjectTORequest(jsonNode,MessageRequest.class);
    }

    public Boolean validate(MessageRequest messageRequest) {
        Boolean isValid = Boolean.TRUE;
        if (messageRequest == null) {
            validationError  = "No Request Data";
            isValid = Boolean.TRUE;
        } else if (messageRequest.getMessage() == null) {
            validationError  = "Message is mandatory";
            isValid = Boolean.FALSE;
        } else if (messageRequest.getIsGroupId() == null) {
            validationError  = "Message is mandatory";
            isValid = Boolean.FALSE;
        } else if (messageRequest.getFromUserId() == null || messageRequest.getReceiversId() == null ) {
            validationError = "FromUserId | ReceversId is mandatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }

}
