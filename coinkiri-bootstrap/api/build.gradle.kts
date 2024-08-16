dependencies {
    implementation(project(":coinkiri-application"))
    implementation(project(":coinkiri-domain"))
    implementation(project(":persistence"))
    implementation(project(":oauth2"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
}