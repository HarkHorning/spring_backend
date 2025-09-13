//package hark.ecom.validators;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
//import static java.lang.annotation.ElementType.TYPE;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//@Target({TYPE, ANNOTATION_TYPE})
//@Retention(RUNTIME)
//@Constraint(validatedBy = PasswordMatchValidator.class)
//@Documented
//public @interface PasswordMatch {
//    String message() default "Passwords do not match";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
