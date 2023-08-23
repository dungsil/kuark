rootProject.name = "kuark"

// Kuark :: Core
include(":kuark-core")

// Kuark JVM :: Validation (JSR-303)
include(":kuark-jvm-validation")

// Kuark JVM :: Hibernate Validation
include(":kuark-jvm-validation--hibernate")

// Define subprojects directory
for (child in rootProject.children) {
  child.projectDir = file("$rootDir/packages/${child.name}")
}
