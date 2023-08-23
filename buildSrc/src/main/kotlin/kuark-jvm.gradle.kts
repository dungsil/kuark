plugins {
  kotlin
}

apply(plugin = "kuark-publish")

repositories {
  mavenCentral()
}

dependencies {
  compileOnly(kotlin("stdlib-jdk8"))
  testImplementation(kotlin("test-junit5"))
}


kotlin {
  jvmToolchain(8)
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }
}
