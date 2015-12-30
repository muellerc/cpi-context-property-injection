package org.apache.cmueller.sample.cpi;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cmueller on 30/12/15.
 */
@Qualifier
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
    /**
     * The property key to look up.
     */
    @Nonbinding
    String value() default "";
}
