package kuark.validation.hibernate

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kuark.validation.RequireAlphabet
import kuark.validation.RequireNumber
import org.hibernate.validator.constraints.CompositionType
import org.hibernate.validator.constraints.ConstraintComposition
import kotlin.reflect.KClass

/**
 * Annotation that can be applied to a field or class to indicate that it requires a value that is either an alphabet character or a number.
 *
 * This annotation is a composition of the `RequireAlphabet` and `RequireNumber` annotations, enforcing that the value must satisfy either one of these constraints.
 *
 * @param message The error message to be returned if the validation fails. Defaults to an empty string.
 * @param groups The array of group classes targeted for validation. Defaults to an empty array.
 * @param payload The array of payload classes targeted for validation. Defaults to an empty array.
 *
 * @see RequireAlphabet
 * @see RequireNumber
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@ConstraintComposition(CompositionType.OR)
@RequireAlphabet
@RequireNumber
annotation class RequireAlphabetOrNumber(
  val message: String = "",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = [],
)
