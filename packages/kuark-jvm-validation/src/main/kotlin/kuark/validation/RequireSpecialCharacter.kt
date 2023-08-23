package kuark.validation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass
import kotlin.text.RegexOption.IGNORE_CASE

/**
 * A custom annotation to validate that a string contains at least one special character.
 *
 * @param message   the error message to be returned if the validation fails
 * @param groups    the validation groups to apply the constraint to
 * @param payload   the payload associated with the constraint
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [RequireSpecialCharacter.Validator::class])
annotation class RequireSpecialCharacter(
  val message: String = "The string must contain at least one special character",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = [],
) {

  class Validator : ConstraintValidator<RequireSpecialCharacter, String> {
    companion object {
      private const val SPECIAL_CHARACTER_PATTERN = "[^a-z0-9]"
      private val regex: Regex = Regex(SPECIAL_CHARACTER_PATTERN, IGNORE_CASE)
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
      return value
        ?.contains(regex)
        ?: false
    }
  }
}
