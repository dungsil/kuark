@file:Suppress("UNUSED_VARIABLE")

import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
  kotlin("multiplatform") version KOTLIN_VERSION
  ktlint() version KTLINT_GRADLE_VERSION
  detekt() version DETEKT_VERSION
  `maven-publish`
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

publishing {
  publications.withType<MavenPublication> {
    val owner = System.getenv("GITHUB_USER")
    val repository = System.getenv("GITHUB_REPOSITORY")
    val repositoryUrl = System.getenv("GITHUB_SERVER_URL") + "/" + repository
    val commitId = System.getenv("GITHUB_SHA")

    repositories {
      maven {
        name = "GithubPackages"
        version = "0.1.0+$commitId"
        url = uri("https://maven.pkg.github.com/$owner")

        credentials {
          username = System.getenv("GITHUB_USER")
          password = System.getenv("GITHUB_TOKEN")
        }
      }
    }

    pom {
      url.set(repositoryUrl)
      licenses {
        license {
          name.set("MIT License")
          url.set("$repositoryUrl/blob/$commitId/LICENSE")
        }
      }
      developers {
        developer {
          name.set("Kim Younggeon")
          email.set("mail@kyg.kr")
        }
      }
      scm {
        url.set(repositoryUrl)
      }
    }
  }
}
