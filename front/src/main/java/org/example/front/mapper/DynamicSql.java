package org.example.front.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DynamicSql {

    String value();
}
