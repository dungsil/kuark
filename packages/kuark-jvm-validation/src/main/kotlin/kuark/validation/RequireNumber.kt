package kuark.validation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * Represents a custom constraint annotation for validating if a string contains at least one number.
 *
 * @property message The error message to be displayed when the validation fails.
 * @property groups The validation groups are targeted by this constraint.
 * @property payload The payloads associated with the constraint.
 *
 * @see Constraint
 * @see ConstraintValidator
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [RequireNumber.Validator::class])
annotation class RequireNumber(
  val message: String = "The string must contain at least one number",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = [],
) {
  class Validator : ConstraintValidator<RequireNumber, String> {

    companion object {
      private val regex = Regex("[0-9]")
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
      return value
        ?.contains(regex)
        ?: false
    }
  }
}
