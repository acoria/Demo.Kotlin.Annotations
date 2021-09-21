package com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta

import com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.MySQLFieldType

class FieldMeta(
    val name: String,
    val type: MySQLFieldType,
    val length: Int,
    val nullable: Boolean,
    val autoIncrement: Boolean,
    val isPrimaryKey: Boolean
)