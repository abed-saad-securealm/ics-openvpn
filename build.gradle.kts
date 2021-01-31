/*
 * Copyright (c) 2012-2019 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */


buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }
}
