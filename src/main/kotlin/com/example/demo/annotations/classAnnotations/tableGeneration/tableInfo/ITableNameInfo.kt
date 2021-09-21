package com.example.demo.annotations.classAnnotations.tableGeneration.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject

interface ITableNameInfo {
    fun getTableNameFromDataObjectAnnotation(dataObjectClass: Class<DataObject>): String
}