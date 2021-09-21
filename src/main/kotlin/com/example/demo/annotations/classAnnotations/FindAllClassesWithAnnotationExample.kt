package com.example.demo.annotations.classAnnotations

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.api.MySQLGeneratorFacade
import org.reflections.Reflections

class FindAllClassesWithAnnotationExample {

    fun run() {
        val reflections = Reflections("com.example.demo.annotations")
        val listOfDataObjectAnnotatedClasses =
            reflections.getTypesAnnotatedWith(DataObject::class.java) as List<Class<DataObject>>
    }
}