package org.example.front.model;

import java.util.Arrays;

public interface EnumCodec {

    Object getCode();

    static <T extends EnumCodec> T value(Class<T> clazz, Object value) {
        return Arrays.stream(clazz.getEnumConstants()).filter(o -> o.getCode().equals(value)).findAny().orElse(null);
    }
}
