dependencies {
    implementation(project(":fall-prevention-common"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
}

tasks {
    withType<Jar> {
        enabled = false
    }
}
