rootProject.name = "kuark"

for (child in rootProject.children) {
  child.projectDir = file("packages/${child.name}")
}
