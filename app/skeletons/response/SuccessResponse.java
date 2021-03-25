package skeletons.response;

import lombok.Getter;
/**
 * @author  MTK
 * @date 13/01/2019
 */
@Getter
public class SuccessResponse implements Response {
    private Integer statusCode;
    private String description;
    private Object data;
    private Boolean isError;

    public SuccessResponse(){}
    public SuccessResponse(Object data) {
        this.data = data;
        this.statusCode = 200;
        this.description = "success";
        this.isError = false;
    }
}

