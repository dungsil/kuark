package kuark.text

/**
 * Prepends the given prefix to the string only if the boolean condition specified by the func parameter is true.
 *
 * @param prefix The prefix to prepend to the string.
 * @param func A function that returns a boolean value determining whether the prefix should be added.
 *
 * @return The string with the prefix prepended if the condition is true, otherwise the original string.
 */
public fun String.prefixIf(prefix: String, func: () -> Boolean): String = if (func()) {
  "$prefix$this"
} else {
  this
}

/**
 * Returns a new string that has the specified prefix added to it if the original string does not already start with the prefix.
 *
 * @param prefix The prefix to add to the string.
 * @return A new string with the prefix is added if the original string does not start with the prefix,
 *         otherwise returns the original string.
 */
public fun String.prefixIfNot(prefix: String): String = this.prefixIf(prefix) { this.startsWith(prefix).not() }

/**
 * Returns a new string with the specified suffix appended to the original string
 * if the given condition is true. Otherwise, returns the original string.
 *
 * @param suffix The suffix to be appended to the original string.
 * @param func The function that determines whether the suffix should be appended.
 * @return A new string with the suffix appended if the condition is true, otherwise
 *         returns the original string.
 */
public fun String.suffixIf(suffix: String, func: () -> Boolean): String = if (func()) {
  "$this$suffix"
} else {
  this
}

/**
 * Returns the given suffix added to the string if it is not already present.
 *
 * @param suffix the suffix to be added
 * @return the resulting string with the suffix added if it is not already present, otherwise, the original string
 */
public fun String.suffixIfNot(suffix: String): String = this.suffixIf(suffix) { this.endsWith(suffix).not() }
