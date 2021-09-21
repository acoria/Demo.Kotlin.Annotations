package com.example.demo.annotations.classAnnotations.tableGeneration.mapper

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObjectId
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObjectPrimaryKey
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.isMetaAnnotationPresent
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.MySQLFieldType
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta
import java.lang.reflect.Field

class PropertyToFieldMetaMapper {
    fun map(property: Field): FieldMeta {
        var nullable = true
        var autoIncrement = false
        var isPrimaryKey = false
        if (property.isAnnotationPresent(DataObjectId::class.java)) {
            nullable = false
            autoIncrement = true
        }

        isPrimaryKey = determineIsPrimaryKey(property)

        return FieldMeta(property.name, getType(property), getLength(property), nullable, autoIncrement, isPrimaryKey)
    }

    private fun determineIsPrimaryKey(property: Field): Boolean {
        //is property annotated
        if (property.isAnnotationPresent(DataObjectPrimaryKey::class.java)) {
            return true
        }

        //is one of its annotations annotated
        return property.isMetaAnnotationPresent<DataObjectPrimaryKey>()
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