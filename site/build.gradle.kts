import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    id("com.varabyte.kobweb.application")
    id("com.varabyte.kobwebx.markdown")
}

group = "com.varabyte.kobweb.guide"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
        }
    }
    kspProcessorDependency.set("com.varabyte.kobweb:site-processors")
}

kotlin {
    configAsKobwebApplication("guide")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation("com.varabyte.kobweb:kobweb-core")
            implementation("com.varabyte.kobweb:kobweb-silk")
            implementation("com.varabyte.kobwebx:silk-icons-fa")
            implementation("com.varabyte.kobwebx:kobwebx-markdown")
            
        }
    }
}
