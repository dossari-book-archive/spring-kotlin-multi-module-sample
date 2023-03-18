plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}
dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation(project(":core"))
    implementation(project(":data"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
