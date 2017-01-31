package io.ashdavies.gradle.inject

import java.lang.annotation.Retention
import java.lang.annotation.Documented
import static java.lang.annotation.RetentionPolicy.RUNTIME

@Qualifier
@Documented
@Retention(RUNTIME)
@interface Named {

  String value() default ""
}
