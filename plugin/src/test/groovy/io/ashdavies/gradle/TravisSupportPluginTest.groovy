package io.ashdavies.gradle

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test;

import static org.junit.Assert.*;

class TravisSupportPluginTest {

  @Test
  void greeterPluginAddsGreetingTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    project.pluginManager.apply 'io.ashdavies.gradle.travis-support'

    assertTrue(project.tasks.hello instanceof BintrayManifestTask)
  }
}
