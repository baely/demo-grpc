plugins {
    id("java")
//    id("build.buf") version "0.8.4"
    id("com.google.protobuf") version("0.9.3")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.23.2")
    implementation("io.grpc:grpc-stub:1.55.1")
    implementation("io.grpc:grpc-core:1.55.1")
    implementation("io.grpc:grpc-protobuf:1.55.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.grpc:grpc-netty:1.55.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
