plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
}

group = "com.verimsolution"
version = "1.0.0"

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}

android {
    namespace = "com.verimsolution.tailwind"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.test.junit4)
    implementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.verimsolution"
                artifactId = "tailwind"
                version = "1.0.0"
                from(components["release"])
//                pom {
//                    name.set("Tailwind")
//                    description.set("Tailwind for Android")
//                    url.set("https://github.com/plelouch7/Android-Tailwind-Theme")
//                    licenses {
//                        license {
//                            name.set("The Apache License, Version 2.0")
//                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                        }
//                    }
//                    developers {
//                        developer {
//                            id.set("plelouch")
//                            name.set("Takougnade Prosper")
//                            email.set("plelouch7@gmail.com")
//                        }
//                    }
//                    scm {
//                        connection.set("scm:git:git://github.com/plelouch7/Android-Tailwind-Theme.git")
//                        developerConnection.set("scm:git:ssh://github.com/plelouch7/Android-Tailwind-Theme.git")
//                        url.set("https://github.com/plelouch7/Android-Tailwind-Theme")
//                    }
//                }
            }
        }
//        repositories {
//            maven {
//                name = "sonatypeStaging"
//                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
//                credentials {
//                    username = project.findProperty("ossrhUsername") as String?
//                    password = project.findProperty("ossrhPassword") as String?
//                }
//            }
//            maven {
//                name = "sonatypeSnapshots"
//                url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//                credentials {
//                    username = project.findProperty("ossrhUsername") as String?
//                    password = project.findProperty("ossrhPassword") as String?
//                }
//            }
//        }
    }
}