package kuark.validation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * This class represents a custom annotation that can be applied to fields or classes to specify that the string value should only contain alphabets, numbers, and certain allowed characters.
 *
 * The allowed characters can be specified using the 'allow' parameter.
 * The validation message can be customized using the 'message' parameter.
 *
 * The validation logic is implemented in the nested class AllowSpecialCharacter, which implements the ConstraintValidator interface.
 * The AllowSpecialCharacter checks if the given string contains any characters that are not alphabets, numbers, or the allowed characters.
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [AllowSpecialCharacter.AllowSpecialCharacter::class])
annotation class AllowSpecialCharacter(
  val allow: CharArray = ['-', '_'],

  val message: String = "The string can only contain alphabets, numbers, and allow characters",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = [],
) {
  class AllowSpecialCharacter : ConstraintValidator<kuark.validation.AllowSpecialCharacter, String> {
    companion object {
      // '[^a-zA-Z0-9]' means alphanumeric,
      // non-alphanumeric Insert user-specified special characters in '%s'
      private const val ALLOW_CHARACTERS_PATTERN_TEMPLATE = "[^a-zA-Z0-9%s]"
    }

    private lateinit var regex: Regex

    override fun initialize(annotation: kuark.validation.AllowSpecialCharacter) {
      val specialCharacters = Regex.escape(annotation.allow.joinToString(""))
      this.regex = String.format(ALLOW_CHARACTERS_PATTERN_TEMPLATE, specialCharacters).toRegex()
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
      if (value == null) {
        return false
      }

      return !value.contains(regex)
    }
  }
}
