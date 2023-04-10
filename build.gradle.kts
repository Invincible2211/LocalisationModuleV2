plugins {
    id("java")
}

group = "de.fynn.localisation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("com.github.Minestom:Minestom:8ad2c7701f")
}

tasks.test {
    useJUnitPlatform()
}