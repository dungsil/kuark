plugins {
  `maven-publish`
}

publishing {
  publications {
    repositories {
      maven {
        name = "GitHub"
        url = uri("https://maven.pkg.github.com/dungsil/kuark")

        credentials {
          username = "dungsil"
          password = System.getenv("GH_TOKEN")
        }
      }
    }

    create<MavenPublication>("GitHub") {
      from(components["kotlin"])
    }
  }
}
