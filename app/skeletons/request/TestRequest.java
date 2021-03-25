package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import models.TestClass;
import utils.Utils;

public class TestRequest {
    private String name;
    private String text;
    public static String validationError;

    public static TestRequest build(JsonNode jsonNode) {
        return (TestRequest) Utils.converObjectTORequest(jsonNode,TestRequest.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Boolean validate(TestRequest testRequest) {
        Boolean isValid = Boolean.TRUE;
        if(testRequest == null) {
            validationError = "userName is mandatory";
            isValid = Boolean.FALSE;
        }
        else if(testRequest.getName() == null) {
            validationError = "Name Field is mandatory";
            isValid = Boolean.TRUE;
        }
        return isValid;
    }

}
