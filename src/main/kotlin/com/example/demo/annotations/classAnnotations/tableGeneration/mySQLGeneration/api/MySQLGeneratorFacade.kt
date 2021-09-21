package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.mapper.DataObjectToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.MySQLTableGenerator

class MySQLGeneratorFacade : IMySQLGeneratorFacade {
    override fun createMySQLTable(dataObjectClass: Class<DataObject>): String {
        return MySQLTableGenerator(DataObjectToTableMetaMapper(dataObjectClass).map()).generate()
    }
}