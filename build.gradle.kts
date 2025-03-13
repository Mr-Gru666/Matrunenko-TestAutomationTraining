plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.traineProject"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


val encoding = "UTF-8"

val junitVersion = "5.11.3"
val assertjVersion = "3.26.3"
val allureVersion = "2.27.0"
val aspectjVersion = "1.9.21"
val lombokVersion = "1.18.32"
val selenideVersion = "7.7.0"
val restAssuredVersion = "5.3.1"
val cucumberVersion = "7.21.0"
val wiremockVersion = "3.12.0"
val slf4jVersion = "2.0.16"

dependencies {
    // JUnit 5
    implementation(platform("org.junit:junit-bom:$junitVersion"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.junit.platform:junit-platform-launcher")
    implementation("org.junit.platform:junit-platform-suite")


    // AssertJ
    implementation("org.assertj:assertj-core:$assertjVersion")

    // SELENIDE
    implementation("com.codeborne:selenide:$selenideVersion")

    // RestAssured для API-тестов
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")

    // Cucumber для BDD
    implementation("io.cucumber:cucumber-java:$cucumberVersion")
    implementation("io.cucumber:cucumber-junit-platform-engine:7.21.0")

    // WireMock для эмуляции API
    implementation("org.wiremock:wiremock:$wiremockVersion")

    // Allure для отчётов
    // Allure
    implementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    implementation("io.qameta.allure:allure-junit5")
    implementation("io.qameta.allure:allure-selenide")
    implementation("io.qameta.allure:allure-cucumber7-jvm")

    // Lombok - no boilerplate code
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

    // Logging
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
}

tasks.test {
    useJUnitPlatform()
}
