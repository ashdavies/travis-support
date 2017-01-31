package io.ashdavies.gradle.producer

import io.ashdavies.gradle.component.FileComponent
import io.ashdavies.gradle.inject.Producer

class FileComponentProducer implements Producer<FileComponent> {

  @Override
  FileComponent get() {
    FileComponent.builder()
        .includePattern("build/bin(.*)*/(.*\\\\.gem)")
        .excludePattern(".*/do-not-deploy/.*")
        .uploadPattern("gems/\$2")
        .build()
  }
}
