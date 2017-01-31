package io.ashdavies.gradle

import groovy.json.JsonBuilder
import io.ashdavies.gradle.component.FileComponent
import io.ashdavies.gradle.component.PackageComponent
import io.ashdavies.gradle.component.VersionComponent
import io.ashdavies.gradle.generator.ComponentGenerator
import io.ashdavies.gradle.generator.FilesGenerator
import io.ashdavies.gradle.generator.PackageGenerator
import io.ashdavies.gradle.generator.VersionGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenerateBintrayManifestTask extends DefaultTask {

  ComponentGenerator<PackageComponent> packageGenerator = new PackageGenerator()
  ComponentGenerator<VersionComponent> versionGenerator = new VersionGenerator()
  ComponentGenerator<FileComponent> fileGenerator = new FilesGenerator()

  @TaskAction
  void generateBintrayManifest() {
    BintrayManifest manifest = BintrayManifest.builder()
        .packageComponent(packageGenerator.generate())
        .versionComponent(versionGenerator.generate())
        .filesComponent([fileGenerator.generate()] as FileComponent[])
        .publish(false)
        .build()

    write(manifest)
  }

  void write(BintrayManifest manifest) {
    getOutputFile().write(new JsonBuilder(manifest).toPrettyString())
  }

  File getOutputFile() {
    new File("${getProject().buildDir}/bintray.json")
  }
}
