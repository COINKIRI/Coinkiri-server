dependencies {
    implementation(project(":coinkiri-application"))
    implementation(project(":coinkiri-domain"))
    implementation(project(":persistence"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
}