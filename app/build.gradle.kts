plugins {
    id("java")
    application
    checkstyle
    id("org.sonarqube") version "6.0.1.5171"
}
sonar {
    properties {
        property("sonar.projectKey")
        property("sonar.organization")
        property("sonar.host.url")
        property("https://sonarcloud.io")
        property("hostblur")
        property("hOSTBlur_java-project-61")
    }
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
gradle
application {
    mainClass = "hexlet.code.App"
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

checkstyle {
    toolVersion = "10.12.5"  // Актуальная версия
    configFile = file("config/checkstyle/checkstyle.xml")  // Путь к конфигу
}

