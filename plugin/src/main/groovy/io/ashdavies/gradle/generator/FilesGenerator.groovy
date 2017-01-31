package io.ashdavies.gradle.generator

import io.ashdavies.gradle.component.FileComponent

class FilesGenerator implements ComponentGenerator<FileComponent> {

  @Override
  FileComponent generate() {
    FileComponent.builder()
        .includePattern("build/bin(.*)*/(.*\\\\.gem)")
        .excludePattern(".*/do-not-deploy/.*")
        .uploadPattern("gems/\$2")
        .build()
  }
}
