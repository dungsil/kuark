package org.gradle.kotlin.dsl

import org.gradle.api.DomainObjectCollection
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test

fun Project.test(configuration: Test.() -> Unit): DomainObjectCollection<Test> {
  return tasks.withType(Test::class.java, configuration)
}
