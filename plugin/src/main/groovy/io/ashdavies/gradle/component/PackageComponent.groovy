package io.ashdavies.gradle.component

import groovy.transform.builder.Builder

@Builder
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
  String[] licenses
  String[] labels
  boolean publicDownloadNumbers
  boolean publicStats
  AttributeComponent[] attributes
}
