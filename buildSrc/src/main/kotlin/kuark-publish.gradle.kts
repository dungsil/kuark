plugins {
  signing
  `maven-publish`
}

publishing {
  publications {
    repositories {
      if (version.toString().endsWith("SNAPSHOT")) {
        maven {
          name = "MavenCentral"
          url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")

          credentials {
            username = System.getenv("OSRH_USERNAME")
            password = System.getenv("OSRH_PASSWORD")
          }
        }
      } else {
        mavenCentral {
          name = "MavenCentral"

          credentials {
            username = System.getenv("OSRH_USERNAME")
            password = System.getenv("OSRH_PASSWORD")
          }
        }
      }

      maven {
        name = "GitHub"
        url = uri("https://maven.pkg.github.com/dungsil/kuark")

        credentials {
          username = "dungsil"
          password = System.getenv("GH_TOKEN")
        }
      }
    }

    create<MavenPublication>("Default") {
      from(components["kotlin"])
    }
  }
}
