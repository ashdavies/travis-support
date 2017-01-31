package io.ashdavies.gradle.component

import groovy.transform.builder.Builder

@Builder
class VersionComponent {

  String name
  String desc
  String released
  String vcsTag
  AttributeComponent[] attributes
  boolean gpgSign
}
