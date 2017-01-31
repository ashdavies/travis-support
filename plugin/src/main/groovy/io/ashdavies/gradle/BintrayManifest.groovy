package io.ashdavies.gradle

import com.google.gson.annotations.SerializedName
import groovy.transform.builder.Builder
import io.ashdavies.gradle.component.FileComponent
import io.ashdavies.gradle.component.PackageComponent
import io.ashdavies.gradle.component.VersionComponent

@Builder
class BintrayManifest {

  @SerializedName("package")
  PackageComponent packageComponent

  @SerializedName("version")
  VersionComponent versionComponent

  @SerializedName("files")
  FileComponent[] filesComponent

  boolean publish
}
