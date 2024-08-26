import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {

    implementation(project(":coinkiri-domain"))
    implementation(project(":common"))

    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-webflux")

    api("jakarta.servlet:jakarta.servlet-api:6.0.0")
}
