package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations

@Target(AnnotationTarget.CLASS)
annotation class DataObject(val tableName: String = "")