package io.ashdavies.gradle.component

import groovy.transform.builder.Builder

@Builder
class FileComponent {

  String includePattern
  String excludePattern
  String uploadPattern
}
