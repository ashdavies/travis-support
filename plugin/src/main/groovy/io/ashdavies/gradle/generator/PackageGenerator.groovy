package io.ashdavies.gradle.generator

import io.ashdavies.gradle.component.AttributeComponent
import io.ashdavies.gradle.component.PackageComponent

class PackageGenerator implements ComponentGenerator<PackageComponent> {

  @Override
  PackageComponent generate() {
    PackageComponent.builder()
        .name("auto-upload")
        .repo("myRepo")
        .subject("myBintrayUser")
        .desc("I was pushed completely automatically")
        .websiteUrl("www.jfrog.com")
        .issueTrackerUrl("https://github.com/bintray/bintray-client-java/issues")
        .vcsUrl("https://github.com/bintray/bintray-client-java.git")
        .githubUseTagReleaseNotes(true)
        .githubReleaseNotesFile("RELEASE.txt")
        .licenses(["MIT"] as String)
        .labels(["cool", "awesome", "gorilla"] as String)
        .publicDownloadNumbers(false)
        .publicStats(false)
        .attributes([
          AttributeComponent.create("att1", "val1"),
          AttributeComponent.create("att2", 1, 2.2, 4),
          AttributeComponent.create("att4", new Date())
        ] as AttributeComponent[])
        .build()
  }
}
