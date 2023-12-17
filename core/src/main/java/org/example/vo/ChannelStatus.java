package org.example.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.annotation.ValueObject;

@Getter
@RequiredArgsConstructor
@ValueObject("渠道状态")
public enum ChannelStatus {

    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    @JsonValue
    private final Integer code;

    private final String desc;

}
