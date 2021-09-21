package com.example.demo.annotations.classAnnotations.tableGeneration.environment

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration.api.MySQLGeneratorFacade
import org.reflections.Reflections
import kotlin.reflect.KClass

class EnvironmentCreator {
    fun create() {
        val reflections = Reflections("com.example.demo.annotations")
        val listOfDataObjectAnnotatedClasses =
            reflections.getTypesAnnotatedWith(DataObject::class.java)

        listOfDataObjectAnnotatedClasses.forEach {
            val sql = MySQLGeneratorFacade().createMySQLTable(it.kotlin as KClass<DataObject>)
        }
    }
}