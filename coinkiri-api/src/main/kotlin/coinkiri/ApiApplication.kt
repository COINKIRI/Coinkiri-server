package coinkiri

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [ApiApplication::class])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}