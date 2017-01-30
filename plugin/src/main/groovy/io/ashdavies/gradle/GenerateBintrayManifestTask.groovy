package io.ashdavies.gradle

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction

class GenerateBintrayManifestTask extends DefaultTask {

  @TaskAction
  void generateBintrayManifest() {
    System.out.println("Generating bintray manifest")
  }
}
