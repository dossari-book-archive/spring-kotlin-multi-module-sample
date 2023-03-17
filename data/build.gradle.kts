plugins {
    id("org.flywaydb.flyway")
    kotlin("jvm")
    kotlin("plugin.jpa")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

flyway {
    url = "jdbc:postgresql://localhost:5432/postgres_sample"
    user = "postgres"
    password = "password"
}

dependencies {
    implementation(project(":core"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
}
