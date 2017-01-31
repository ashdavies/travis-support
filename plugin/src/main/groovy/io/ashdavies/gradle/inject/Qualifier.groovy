package io.ashdavies.gradle.inject

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.Target
import static java.lang.annotation.RetentionPolicy.RUNTIME
import static java.lang.annotation.ElementType.ANNOTATION_TYPE

@Documented
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
@interface Qualifier {}
