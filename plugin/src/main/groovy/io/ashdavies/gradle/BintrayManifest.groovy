package io.ashdavies.gradle

import groovy.transform.builder.Builder
import io.ashdavies.gradle.component.FileComponent
import io.ashdavies.gradle.component.PackageComponent
import io.ashdavies.gradle.component.VersionComponent

@Builder
//@Immutable
class BintrayManifest {

  PackageComponent packageComponent
  VersionComponent versionComponent
  FileComponent[] filesComponent

  boolean publish
}
