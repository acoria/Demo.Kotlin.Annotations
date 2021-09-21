package com.example.demo.annotations.classAnnotations.dataObjects

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObjectId
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObjectPrimaryKey

@DataObject
class Animal {
    @DataObjectId
    val id: Int = 0

    @DataObjectPrimaryKey
    val color: String = ""
}