group = "com.improve_future"
version = "1.0-SNAPSHOT"

buildscript {
    val kotlinVersion = "1.1-M04"
    extra["kotlin_version"] = kotlinVersion

    repositories {
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

apply { plugin("java") }
apply { plugin("kotlin") }


repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.11")
    // kotlin
    val kotlinVersion = extra["kotlin_version"] as String
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testCompile("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
