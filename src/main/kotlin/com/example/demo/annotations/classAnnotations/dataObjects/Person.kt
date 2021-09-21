package com.example.demo.annotations.classAnnotations.dataObjects

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObjectId

@DataObject("mypersontable")
class Person{
    @DataObjectId
    val id: Int = 0
    val name: String = ""
}