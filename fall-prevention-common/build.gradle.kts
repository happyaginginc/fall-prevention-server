dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks {
    withType<Jar> {
        enabled = false
    }
}
