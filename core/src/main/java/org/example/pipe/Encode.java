package org.example.pipe;

import java.util.Map;
import java.util.function.Function;

public class Encode {

    private Map<Class<?>, Function<Object, Object>> mapper;

    @SuppressWarnings("unchecked")
    public <T,R> R encode(T t) {
        return (R) mapper.get(t.getClass()).apply(t);
    }

}
