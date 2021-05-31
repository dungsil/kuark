package org.gradle.kotlin.dsl

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * @see [JLLeitschuh/ktlint-gradle](https://github.com/JLLeitschuh/ktlint-gradle)
 */
fun PluginDependenciesSpec.ktlint(): PluginDependencySpec {
  return id("org.jlleitschuh.gradle.ktlint")
}

/**
 * @see [detekt/detekt](https://github.com/detekt/detekt)
 */
fun PluginDependenciesSpec.detekt(): PluginDependencySpec {
  return id("io.gitlab.arturbosch.detekt")
}
