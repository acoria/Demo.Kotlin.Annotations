package com.example.demo.annotations.classAnnotations.tableGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.mapper.DataObjectToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQL.MySQLTableGenerator

class MySQLGeneratorFacade : IMySQLGeneratorFacade {
    override fun createMySQLTable(dataObjectClass: Class<DataObject>): String {
        return MySQLTableGenerator(DataObjectToTableMetaMapper(dataObjectClass).map()).generate()
    }
}