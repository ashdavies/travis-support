package io.ashdavies.gradle

import com.google.gson.Gson
import io.ashdavies.gradle.component.FileComponent
import io.ashdavies.gradle.component.PackageComponent
import io.ashdavies.gradle.component.VersionComponent
import io.ashdavies.gradle.factory.GsonFactory
import io.ashdavies.gradle.inject.Producer
import io.ashdavies.gradle.producer.FileComponentProducer
import io.ashdavies.gradle.producer.PackageComponentProducer
import io.ashdavies.gradle.producer.VersionComponentProducer
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class BintrayManifestTask extends DefaultTask {

  static final String NAME = 'generateBintrayManifest'
  static final String GROUP = 'publishing'

  static final String DESCRIPTION = 'Generates a Travis compatible Bintray manifest'

  Producer<PackageComponent> packageComponentProducer = new PackageComponentProducer()
  Producer<VersionComponent> versionComponentProducer = new VersionComponentProducer()
  Producer<FileComponent> fileComponentProducer = new FileComponentProducer()

  @TaskAction
  void generateBintrayManifest() {
    BintrayManifest manifest = BintrayManifest.builder()
        .packageComponent(packageComponentProducer.get())
        .versionComponent(versionComponentProducer.get())
        .filesComponent([fileComponentProducer.get()] as FileComponent[])
        .publish(false)
        .build()

    write(GsonFactory.create().get(), manifest)
  }

  void write(Gson gson, BintrayManifest manifest) {
    getOutputFile().write(gson.toJson(manifest))
  }

  File getOutputFile() {
    new File("${getProject().buildDir}/bintray.json")
  }
}
