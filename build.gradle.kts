plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    implementation ("org.mapstruct:mapstruct:1.5.4.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.4.Final")
}

tasks.test {
    useJUnitPlatform()
}