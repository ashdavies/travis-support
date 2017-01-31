package io.ashdavies.gradle.component

class AttributeComponent<T> {

  static final STRING = "string"
  static final NUMBER = "number"
  static final DATE = "date"

  String name
  T[] values

  String type

  private AttributeComponent(String name, T[] values, String type) {
    this.name = name
    this.values = values
    this.type = type
  }

  static AttributeComponent<String> create(String name, String... values) {
    new AttributeComponent<String>(name, values, STRING)
  }

  static AttributeComponent<BigDecimal> create(String name, BigDecimal... values) {
    new AttributeComponent<BigDecimal>(name, values, NUMBER)
  }

  static AttributeComponent<Date> create(String name, Date... dates) {
    new AttributeComponent<Date>(name, dates, DATE)
  }
}
