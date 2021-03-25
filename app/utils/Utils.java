package utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import java.util.List;

/**
 * Class where commonly used functionality is kept
 */
public class Utils {

    /**
     * converts incomming http Requestion in the underlinde "to" class
     * @param from
     * @param to
     * @return
     */
    public static Object converObjectTORequest(Object from, Class to) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Object object = objectMapper.convertValue(from, to);
        return object;
    }

    public static<T> Boolean isEmpty(List<T> list) {
        Boolean isEmpty = Boolean.TRUE;
        if(list != null && list.size() != 0 ) {
            isEmpty = Boolean.FALSE;
        }
        return isEmpty;
    }

}
