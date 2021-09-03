import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
  // IDE
  id("idea")

  // Kotlin
  kotlin("multiplatform") version "1.5.30"
  kotlin("kapt") version "1.5.30"

  // Kotlin code quality
  id("org.jetbrains.dokka") version "1.5.0"
  id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
  id("io.gitlab.arturbosch.detekt") version "1.18.1"
}

group = ""
version = "0.0.0"

repositories {
  mavenCentral()
}

kotlin {
  jvm {
    withJava()
  }

  sourceSets {
    commonMain {
    }

    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
      }
    }
  }
}

idea {
  module {
    excludeDirs.addAll(files(".gradle"))
  }
}

detekt {
  buildUponDefaultConfig = true
  config = files("$rootDir/.detektrc.yml")
}

configure<KtlintExtension> {
  kotlinScriptAdditionalPaths {
    include(fileTree("buildSrc"))
  }
}
