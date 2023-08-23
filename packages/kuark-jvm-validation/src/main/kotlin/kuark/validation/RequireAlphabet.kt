package kuark.validation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass
import kotlin.text.RegexOption.IGNORE_CASE

/**
 * Represents a custom validation annotation that checks if a given value contains at least one alphabet character.
 *
 * Usage:
 *   - Apply this annotation to a field or class that needs to be validated.
 *
 * @param message The error message to be used when validation fails. Default: "The value should contain at least one alphabet character".
 * @param groups The validation groups this constraint belongs to. Default: empty array.
 * @param payload The payload associated with the validation constraint. Default: empty array.
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [RequireAlphabet.Validator::class])
annotation class RequireAlphabet(
  val message: String = "The value should contain at least one alphabet character",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = [],
) {
  class Validator : ConstraintValidator<RequireAlphabet, String> {
    companion object {
      private val regex = Regex("[a-z]", IGNORE_CASE)
    }


    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
      return value
        ?.contains(regex)
        ?: false
    }
  }
}
