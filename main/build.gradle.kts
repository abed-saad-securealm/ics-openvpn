import com.android.build.gradle.api.ApplicationVariant
/*
 * Copyright (c) 2012-2016 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

plugins {
    id("com.android.library")
    id("com.github.dcendents.android-maven")
    id("checkstyle")
    kotlin("android")
    kotlin("android.extensions")

}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(30)  //'Q'.toInt()
        versionCode = 175

        externalNativeBuild {
            cmake {
                //arguments = listOf("-DANDROID_TOOLCHAIN=clang",
                //        "-DANDROID_STL=c++_static")
            }
        }
    }

    testOptions.unitTests.isIncludeAndroidResources = true



  //  externalNativeBuild {
     //   cmake {
     //       setPath(File("${projectDir}/src/main/cpp/CMakeLists.txt"))
     //   }
   // }

    sourceSets {
        getByName("main") {
            assets.srcDirs("src/main/assets", "build/ovpnassets")

        }
    }

    lintOptions {
        enable("BackButton", "EasterEgg", "StopShip", "IconExpectedSize", "GradleDynamicVersion", "NewerVersionAvailable")
        warning("ImpliedQuantity", "MissingQuantity")
        disable("MissingTranslation", "UnsafeNativeCodeLocation")
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }


}

//var swigcmd = "swig"
// Workaround for Mac OS X since it otherwise does not find swig and I cannot get
// the Exec task to respect the PATH environment :(
//if (File("/usr/local/bin/swig").exists())
  //  swigcmd = "/usr/local/bin/swig"


/*fun registerGenTask(variantName: String, variantDirName: String): File {
    val baseDir = File(buildDir, "generated/source/ovpn3swig/${variantDirName}")
    val genDir = File(baseDir, "net/openvpn/ovpn3")

    tasks.register<Exec>("generateOpenVPN3Swig${variantName}")
    {

        doFirst {
            mkdir(genDir)
        }
        commandLine(listOf(swigcmd, "-outdir", genDir, "-outcurrentdir", "-c++", "-java", "-package", "net.openvpn.ovpn3",
                "-Isrc/main/cpp/openvpn3/client", "-Isrc/main/cpp/openvpn3/",
                "-o", "${genDir}/ovpncli_wrap.cxx", "-oh", "${genDir}/ovpncli_wrap.h",
                "src/main/cpp/openvpn3/javacli/ovpncli.i"))

    }
    return baseDir
}*/

/*android.applicationVariants.all(object : Action<ApplicationVariant> {
    override fun execute(variant: ApplicationVariant) {
     //   val sourceDir = registerGenTask(variant.name, variant.baseName.replace("-", "/"))
     //   val task = tasks.named("generateOpenVPN3Swig${variant.name}").get()
//
       // variant.registerJavaGeneratingTask(task, sourceDir)
    }
})*/


dependencies {
    // https://maven.google.com/web/index.html
    // https://developer.android.com/jetpack/androidx/releases/core
    val preferenceVersion = "1.1.1"
    val coreVersion = "1.2.0"
    val materialVersion = "1.1.0"
    val fragment_version = "1.2.4"


    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.core:core:$coreVersion")

    // Is there a nicer way to do this?
    implementation( "androidx.constraintlayout:constraintlayout:1.1.3")
    implementation( "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation( "androidx.cardview:cardview:1.0.0")
    implementation( "androidx.recyclerview:recyclerview:1.0.0")
    implementation( "androidx.appcompat:appcompat:1.1.0")
    implementation( "com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation( "com.squareup.okhttp3:okhttp:3.2.0")
    implementation( "androidx.core:core:$coreVersion")
    implementation( "androidx.core:core-ktx:$coreVersion")
    implementation( "org.jetbrains.anko:anko-commons:0.10.4")
    implementation( "androidx.fragment:fragment-ktx:$fragment_version")
    implementation( "androidx.preference:preference:$preferenceVersion")
    implementation( "androidx.preference:preference-ktx:$preferenceVersion")
    implementation( "com.google.android.material:material:$materialVersion")
    implementation( "androidx.webkit:webkit:1.2.0")

    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    testImplementation("junit:junit:4.13")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("org.robolectric:robolectric:4.3.1")
    testImplementation("androidx.test:core:1.2.0")
}
