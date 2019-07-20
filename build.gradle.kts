//import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

repositories {
    jcenter()
}


group = "org.example"
version = "issue_427"

dependencies {
    compile(kotlin("stdlib"))
    "implementation"("com.amazonaws:aws-lambda-java-core:1.2.0")
    "implementation"("com.amazonaws:aws-lambda-java-events:1.2.0")
    "implementation"("org.apache.logging.log4j:log4j-api:2.8.2")
    "implementation"("org.apache.logging.log4j:log4j-core:2.8.2")

    "implementation"("com.amazonaws:aws-lambda-java-log4j2:1.1.0")
}

//tasks {
//    named<ShadowJar>("shadowJar") {
//        transform(com.github.jengelman.gradle.plugins.shadow.transformers.Log4j2PluginsCacheFileTransformer())
//    }
//}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}