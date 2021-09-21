package com.example.demo.annotations.classAnnotations.tableGeneration.environmentCreator

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.api.MySQLGeneratorFacade
import org.reflections.Reflections

class EnvironmentCreator {
    fun create(){
        val reflections = Reflections("com.example.demo.annotations")
        val listOfDataObjectAnnotatedClasses =
            reflections.getTypesAnnotatedWith(DataObject::class.java)
//        reflections.get

        listOfDataObjectAnnotatedClasses.forEach {
            val sql = MySQLGeneratorFacade().createMySQLTable(it as Class<DataObject>)
        }
    }
}