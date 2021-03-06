package skeletons.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private Long mobileNo;
    private Boolean isOnline;
}
