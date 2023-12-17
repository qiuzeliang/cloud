package org.example.doc.openapi;

import org.example.doc.ApiDocs;
import org.junit.jupiter.api.Test;

class OpenApiTest {

    @Test
    void test() {
        System.out.println(OpenApi.build(new ApiDocs().setTitle("5gmp").setVersion("1.0.0")).encode());
    }

}