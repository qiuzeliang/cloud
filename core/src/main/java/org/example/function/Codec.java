package org.example.function;

import io.vertx.core.json.JsonObject;

public interface Codec {

    default String encode() {
        return JsonObject.mapFrom(this).encode();
    }
}
