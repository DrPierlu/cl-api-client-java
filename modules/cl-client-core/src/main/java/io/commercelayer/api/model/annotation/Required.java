package io.commercelayer.api.model.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.commercelayer.api.domain.OperationType;

@Retention(RUNTIME)
@Target(FIELD)
@Inherited
@Documented
public @interface Required {

	public OperationType[] value() default {};
	
}
