package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject

class TableNameInfo : ITableNameInfo {

    override fun getTableNameFromDataObjectAnnotation(dataObjectClass: Class<DataObject>): String {
        var tableName = getTableNameFromAnnotation(dataObjectClass)
        if (tableName.isEmpty()) {
            tableName = getDefaultTableName(dataObjectClass)
        }
        return tableName
    }

    private fun getDefaultTableName(dataObjectClass: Class<DataObject>): String {
        return "${dataObjectClass.simpleName.lowercase()}s"
    }

    private fun getTableNameFromAnnotation(dataObjectClass: Class<DataObject>): String {
        //Find the annotation "DataObject" from the class object to retrieve its constructor parameters
        val annotation =
            dataObjectClass.declaredAnnotations.find { annotation -> annotation is DataObject } as DataObject
        return annotation.tableName
    }
}