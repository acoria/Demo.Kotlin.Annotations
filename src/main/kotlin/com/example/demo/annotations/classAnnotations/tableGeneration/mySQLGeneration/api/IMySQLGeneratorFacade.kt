package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject

interface IMySQLGeneratorFacade {
    fun createMySQLTable(dataObjectClass: Class<DataObject>): String
}