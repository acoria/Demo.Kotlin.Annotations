package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

class TableNameInfo : ITableNameInfo {

    override fun getTableNameFromDataObjectAnnotation(dataObjectKClass: KClass<DataObject>): String {
        var tableName = getTableNameFromAnnotation(dataObjectKClass)
        if (tableName.isEmpty()) {
            tableName = getDefaultTableName(dataObjectKClass)
        }
        return tableName
    }

    private fun getDefaultTableName(dataObjectKClass: KClass<DataObject>): String {
        return "${dataObjectKClass.simpleName!!.lowercase()}s"
    }

    private fun getTableNameFromAnnotation(dataObjectKClass: KClass<DataObject>): String {
        //Find the annotation "DataObject" from the class object to retrieve its constructor parameters
        return dataObjectKClass.findAnnotation<DataObject>()!!.tableName
    }
}