package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.api

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import kotlin.reflect.KClass

interface IMySQLGeneratorFacade {
    fun createMySQLTable(dataObjectKClass: KClass<DataObject>): String
}