package com.example.demo.annotations.classAnnotations.tableGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject

interface IMySQLGeneratorFacade {
    fun createMySQLTable(dataObjectClass: Class<DataObject>): String
}