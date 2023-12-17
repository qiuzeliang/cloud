package org.example.front.outbound;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(OutboundClientsRegistrar.class)
public @interface EnableOutboundClients {

	String[] value() default {};

}
