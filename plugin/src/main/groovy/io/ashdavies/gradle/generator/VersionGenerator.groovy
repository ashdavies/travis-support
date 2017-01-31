package io.ashdavies.gradle.generator

import io.ashdavies.gradle.component.AttributeComponent
import io.ashdavies.gradle.component.VersionComponent

class VersionGenerator implements ComponentGenerator<VersionComponent> {

  @Override
  VersionComponent generate() {
    VersionComponent.builder()
        .name("0.5")
        .desc("This is a version")
        .released("2015-01-04")
        .vcsTag("0.5")
        .attributes([
          AttributeComponent.create("VerAtt1", "VerVal1"),
          AttributeComponent.create("VerAtt2", 1, 3.3, 5),
          AttributeComponent.create("VerAttr3", new Date())
        ] as AttributeComponent[])
        .gpgSign(false)
        .build()
  }
}
