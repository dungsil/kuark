import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
  kotlin("multiplatform") version KOTLIN_VERSION
  ktlint() version KTLINT_GRADLE_VERSION
  detekt() version DETEKT_VERSION
}

group = "io.kuark"
version = "0.0.0"

repositories {
  mavenCentral()
  gradlePluginPortal()
}

kotlin {
  explicitApi()
  jvm {
    withJava()
  }

  sourceSets {

  }
}

configure<KtlintExtension> {
  kotlinScriptAdditionalPaths {
    include(fileTree("buildSrc"))
  }
}

detekt {
  buildUponDefaultConfig = true
  config = files("$rootDir/.detektrc.yml")
}

test {
  useJUnitPlatform()
}
