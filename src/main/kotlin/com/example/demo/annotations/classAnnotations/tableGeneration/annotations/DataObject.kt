package com.example.demo.annotations.classAnnotations.tableGeneration.annotations

@Target(AnnotationTarget.CLASS)
annotation class DataObject(val tableName: String = "")