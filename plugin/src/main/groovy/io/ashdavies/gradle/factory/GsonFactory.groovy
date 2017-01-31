package io.ashdavies.gradle.factory

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ashdavies.gradle.inject.Factory

class GsonFactory implements Factory<Gson> {

  private static Factory<Gson> INSTANCE = new GsonFactory()

  @Override
  Gson get() {
    new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .create()
  }

  static Factory<Gson> create() {
    INSTANCE
  }
}
