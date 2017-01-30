package io.ashdavies.gradle.component

import groovy.transform.Immutable
import groovy.transform.builder.Builder

@Builder
@Immutable
class PackageComponent {

  String name
  String repo
  String subject
  String desc
  String websiteUrl
  String issueTrackerUrl
  String vcsUrl
  boolean githubUseTagReleaseNotes
  String githubReleaseNotesFile
  List<String> licenses
  List<String> labels
  boolean publicDownloadNumbers
  boolean publicStats
  List<AttributeComponent> attributes
}
