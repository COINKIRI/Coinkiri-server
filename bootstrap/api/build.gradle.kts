dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":persistence"))
    implementation(project(":oauth2"))
    implementation(project(":redis"))
    implementation(project(":upbit"))

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

}