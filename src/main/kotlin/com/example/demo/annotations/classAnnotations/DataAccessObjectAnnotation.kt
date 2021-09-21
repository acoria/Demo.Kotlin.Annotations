package com.example.demo.annotations.classAnnotations

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class DataAccessObjectAnnotation(val doClass: KClass<*>)