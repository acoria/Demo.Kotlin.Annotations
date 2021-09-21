package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations

import java.lang.reflect.Field

inline fun <reified T> Field.isMetaAnnotationPresent(): Boolean {
    this.declaredAnnotations.forEach { annotation ->
        val dataObjectPrimaryKey =
            annotation.annotationClass.annotations.filterIsInstance<T>().firstOrNull()
        if (dataObjectPrimaryKey != null) {
            return true
        }
    }
    return false
}