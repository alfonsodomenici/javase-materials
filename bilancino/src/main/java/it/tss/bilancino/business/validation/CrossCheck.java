/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author tss
 */
@Documented
@Constraint(validatedBy = CrossCheckConstraintValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CrossCheck {

  String message() default "{it.tss.bilancino.business.validation.CrossCheck}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
