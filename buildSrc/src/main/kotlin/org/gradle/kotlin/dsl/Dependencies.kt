package org.gradle.kotlin.dsl

fun kotlinLogging(target: String = "", version: String = KOTLIN_LOGGING_VERSION): String {
  val module = if (target.isNotEmpty()) { "-$target" } else { "" }
  return "io.github.microutils:kotlin-logging$module:$version"
}
