package com.example.demo.annotations.classAnnotations.tableGeneration.tableInfo

import com.example.demo.annotations.classAnnotations.dataObjects.Person
import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject

class TableNameInfo : ITableNameInfo {

    override fun getTableNameFromDataObject(dataObjectClass: Class<DataObject>): String {
        (dataObjectClass as Annotation)
        return "${dataObjectClass.simpleName.lowercase()}s"
    }
}