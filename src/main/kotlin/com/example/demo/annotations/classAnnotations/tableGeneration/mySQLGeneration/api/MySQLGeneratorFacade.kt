package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.mapper.DataObjectToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.MySQLTableGenerator
import kotlin.reflect.KClass

class MySQLGeneratorFacade : IMySQLGeneratorFacade {
    override fun createMySQLTable(dataObjectKClass: KClass<DataObject>): String {
        return MySQLTableGenerator(DataObjectToTableMetaMapper(dataObjectKClass).map()).generate()
    }
}