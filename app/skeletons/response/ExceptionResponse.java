package skeletons.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse implements Response{

    private Integer statusCode;

    private String description;


    public ExceptionResponse(String description) {
        this.statusCode = 222;
        this.description = description;
    }
}
