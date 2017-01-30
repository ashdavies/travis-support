package io.ashdavies.gradle.component

import groovy.transform.Immutable
import groovy.transform.builder.Builder

@Builder
@Immutable
class AttributeComponent<T> {

  static final STRING = "string"
  static final NUMBER = "number"
  static final DATE = "date"

  String name
  List<T> values
  String type
}
