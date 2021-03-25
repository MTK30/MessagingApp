package skeletons.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
public class MessageResponse {

    private String message;

    private Date createdDate;

    private String fromUserName;

    private Boolean isLeft;

}
