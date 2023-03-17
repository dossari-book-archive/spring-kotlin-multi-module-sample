import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion: String by System.getProperties()
    val springBootVersion: String by System.getProperties()

    id("org.springframework.boot") version springBootVersion apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.flywaydb.flyway") version "8.2.0" apply false

    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false
}

allprojects {

    apply {
        plugin("kotlin")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }

    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        val runtimeOnly by configurations
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        runtimeOnly("org.postgresql:postgresql")

        // testImplementation("com.ninja-squad:springmockk:3.1.0")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
            exclude(module = "mockito-core")
        }
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<KotlinCompile> {
        // dependsOn("ktlintCheck")
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
