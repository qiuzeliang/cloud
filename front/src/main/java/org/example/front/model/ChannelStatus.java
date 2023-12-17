package org.example.front.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChannelStatus implements EnumCodec {

    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    private final Integer code;

    private final String desc;
}
