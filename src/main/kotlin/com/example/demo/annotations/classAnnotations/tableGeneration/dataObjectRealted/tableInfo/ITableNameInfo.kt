package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject

interface ITableNameInfo {
    fun getTableNameFromDataObjectAnnotation(dataObjectClass: Class<DataObject>): String
}