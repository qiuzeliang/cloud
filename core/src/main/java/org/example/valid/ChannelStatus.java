package org.example.valid;


import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ChannelStatus {

    String name() default "渠道状态";

    String message() default "";

    Class<? extends Enum<?>> format() default org.example.vo.ChannelStatus.class;

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

}
