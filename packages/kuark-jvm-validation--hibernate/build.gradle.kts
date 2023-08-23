apply(plugin = "kuark-jvm")

dependencies {
  "api"(project(":kuark-jvm-validation"))
  "api"("org.hibernate.validator:hibernate-validator:8.0.1.Final")
}
