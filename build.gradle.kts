@file:Suppress("UNUSED_VARIABLE")

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
    val commonMain by getting {
      dependencies {
        implementation(kotlinLogging(version = KOTLIN_LOGGING_API_VERSION))
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    val jvmMain by getting {
      dependencies {
        implementation(kotlinLogging("jvm"))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
      }
    }
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
