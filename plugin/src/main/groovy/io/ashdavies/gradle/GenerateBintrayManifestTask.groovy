package io.ashdavies.gradle

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

  Gson gson = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .setPrettyPrinting()
      .create()

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
    getOutputFile().write(gson.toJson(manifest))
  }

  File getOutputFile() {
    new File("${getProject().buildDir}/bintray.json")
  }
}
