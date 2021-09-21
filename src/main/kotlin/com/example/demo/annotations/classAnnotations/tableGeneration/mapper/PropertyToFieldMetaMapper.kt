package com.example.demo.annotations.classAnnotations.tableGeneration.mapper

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObjectId
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQL.MySQLFieldType
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.FieldMeta
import java.lang.reflect.Field

class PropertyToFieldMetaMapper {
    fun map(property: Field): FieldMeta {
        var nullable = true
        var autoIncrement = false
        var isPrimaryKey = false
        if (property.isAnnotationPresent(DataObjectId::class.java)) {
            nullable = false
            autoIncrement = true
            isPrimaryKey = true
        }
        return FieldMeta(property.name, getType(property), getLength(property), nullable, autoIncrement, isPrimaryKey)
    }

    private fun getType(property: Field): MySQLFieldType {
        return when (property.type.name) {
            "java.lang.String" -> MySQLFieldType.VARCHAR
            "int" -> MySQLFieldType.INT
            else -> throw RuntimeException("Something wrong with the DbFieldType enum")
        }
    }

    private fun getLength(property: Field): Int {
        return when (getType(property)) {
            MySQLFieldType.VARCHAR -> 250
            MySQLFieldType.INT -> 12
        }
    }
}