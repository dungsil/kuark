import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
  // IDE
  id("idea")

  // Kotlin
  kotlin("multiplatform") version "1.5.30" apply false

  // Kotlin code quality
  id("org.jetbrains.dokka") version "1.5.30"
  id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
  id("io.gitlab.arturbosch.detekt") version "1.18.1"
}

allprojects {
  group = ""
  version = "0.0.0"

  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin-multiplatform")

  configure<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension> {
    mingwX64 {
      binaries {
        executable()
      }
    }

    macosX64 {
      binaries {
        executable()
      }
    }

    linuxX64 {
      binaries {
        executable()
      }
    }

    sourceSets {
      val commonMain by getting {
        dependencies {
          implementation(kotlin("stdlib-common"))
        }
      }

      val commonTest by getting {
        dependencies {
          implementation(kotlin("test-common"))
        }
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
