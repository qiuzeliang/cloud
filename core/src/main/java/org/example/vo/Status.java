package org.example.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Status {

    OPEN(0, "open"),
    CLOSE(1, "close");

    private final Integer code;

    private final String desc;
    public static boolean support(Integer code) {
        return Arrays.stream(Status.values()).anyMatch(o-> o.code.equals(code));
    }
}
