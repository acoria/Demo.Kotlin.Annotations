package com.example.demo.annotations.classAnnotations

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import org.reflections.Reflections

class FindAllClassesWithAnnotationExample {

    fun run() {
        val reflections = Reflections("com.example.demo.annotations")
        val listOfDataObjectAnnotatedClasses =
            reflections.getTypesAnnotatedWith(DataObject::class.java) as List<Class<DataObject>>
    }
}