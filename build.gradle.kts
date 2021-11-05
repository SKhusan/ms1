plugins {
    // https://github.com/spring-gradle-plugins/dependency-management-plugin
    id("io.spring.dependency-management") version "1.0.9.RELEASE"

    // https://docs.spring.io/spring-boot/docs/2.2.x/gradle-plugin/reference/html/
    id("org.springframework.boot") version "2.2.4.RELEASE"

    // https://github.com/ben-manes/gradle-versions-plugin
    id("org.jetbrains.kotlin.jvm") version "1.3.61"

    java
    idea
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    jcenter()
}

group = "com.khusan"

val immutablesVersion: String by project
val testContainersVersion: String by project
val springCloudVersion: String by project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    implementation("io.javaslang:javaslang:2.0.2")
    implementation("org.apache.commons:commons-lang3")
    implementation("org.json:json:20190722")
    implementation("com.byteowls:jopencage:1.4.0")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.3")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")


    //tests
    testAnnotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter:${testContainersVersion}")
    testImplementation("org.testcontainers:testcontainers:${testContainersVersion}")
}