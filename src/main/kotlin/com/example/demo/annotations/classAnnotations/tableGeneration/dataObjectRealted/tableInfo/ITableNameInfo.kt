package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import kotlin.reflect.KClass

interface ITableNameInfo {
    fun getTableNameFromDataObjectAnnotation(dataObjectKClass: KClass<DataObject>): String
}