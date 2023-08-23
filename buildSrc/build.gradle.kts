import org.jetbrains.kotlin.konan.properties.loadProperties

val props = loadProperties("$rootDir/../gradle.properties")

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
  mavenCentral()
}

dependencies {
  implementation(kotlin("gradle-plugin", "${props["kotlin.version"]}"))
}
