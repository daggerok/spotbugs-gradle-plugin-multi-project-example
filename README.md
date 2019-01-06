# spotbugs gradle multi-project build [![Build Status](https://travis-ci.org/daggerok/spotbugs-gradle-plugin-multi-project-example.svg?branch=master)](https://travis-ci.org/daggerok/spotbugs-gradle-plugin-multi-project-example)
Example of usage `spotbugs-gradle-plugin` (findbugs replacement) with HTML reports enabled in multi module Gradle project

config:

`build.gradle` file:

```gradle
buildscript {
  ext {
    spotbugsVersion = '1.6.8'
    toolVersion = '3.1.10'
  }
}

plugins { 
  id 'com.github.spotbugs' version '1.6.8' apply false
}

apply from: "$rootProject.projectDir/gradle/spotbugs.gradle"

defaultTasks 'clean', 'check'
```

`gradle/spotbugs.gradle` file:

```gradle
buildscript {
  repositories {
    maven { url "https://plugins.gradle.org/m2/" }
  }
  dependencies {
    classpath "gradle.plugin.com.github.spotbugs:spotbugs-gradle-plugin:$spotbugsVersion"
  }
}

subprojects {
  apply plugin: "com.github.spotbugs"

  repositories {
    maven { url "https://plugins.gradle.org/m2/" }
  }

  spotbugs {
    toolVersion = project.toolVersion
    effort = "max"
    ignoreFailures = project.findProperty('ignoreBugs') != null
  }

  tasks.withType(com.github.spotbugs.SpotBugsTask) {
    reports {
      html {
        enabled = true
      }
      xml {
        enabled = false
      }
    }
  }
}
```

versions:

- gradle: 5.1
- spotbugs-gradle-plugin: 1.6.8
- tool: 3.1.10

usage:

```bash
./gradlew               # to be failed
./gradlew -PignoreBugs  # do not failed on found bugs
```

links:

- [spotbugs gradle plugin html report in multi-project issue](https://github.com/spotbugs/spotbugs-gradle-plugin/issues/32)
- [not generates HTML report when lombok gradle plugin enabled issue](https://github.com/spotbugs/spotbugs-gradle-plugin/issues/94)
