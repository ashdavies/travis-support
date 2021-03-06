package io.ashdavies.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class TravisSupportPlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.task(type: BintrayManifestTask, BintrayManifestTask.NAME)
  }
}
