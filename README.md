### Travis Support

![Build Status](https://img.shields.io/travis/ashdavies/travis-support.svg)
![Version](https://img.shields.io/badge/version-0.1.0-yellowgreen.svg)
![License](https://img.shields.io/badge/license-apache%202.0-blue.svg)

#### Description
Generate a manifest used for Travis deployment to Bintray

#### Installation
```gradle
apply plugin: 'travis-support'

buildscript {
  repositories {
    jcenter()
  }
  
  dependencies {
    classpath 'io.ashdavies.gradle:travis-support:0.1.0'
  }
}
```

#### Usage
```yml
before_deploy
  ./gradlew generateBintrayManifest
    -PgroupId 'io.ashdavies.gradle'
    -PartifactId 'travis-support'
    -Pversion '0.1.0'
    -Pname 'Travis Support'
    -Pdescription 'Generate bintray manifest'
    -Purl 'https://www.github.com/ashdavies/bintray-support'
    -Plicenses 'Apache 2.0'

deploy
  - provider: bintray
    file: build/bintray.json
```
