plugins {
  `kotlin-multiplatform`
}

apply(plugin = "kuark-publish")

repositories {
  mavenCentral()
}

kotlin {
  explicitApi() // make the API public
  withSourcesJar(publish = true)

  jvm {
    jvmToolchain(8)
  }

  // Source sets
  sourceSets {
    commonMain {
      dependencies {
        compileOnly(kotlin("stdlib-common"))
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    val jvmMain by getting {
      dependencies {
        compileOnly(kotlin("stdlib-jdk8"))
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
      }
    }
  }
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }
}
