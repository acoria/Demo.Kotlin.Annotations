package com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

internal class TableNameInfoTest {

    @Test
    fun getTableNameFromDataObjectAnnotation() {
        assertEquals(TableNameInfo().getTableNameFromDataObjectAnnotation(TestDataObjectWithTableName::class as KClass<DataObject>), tablename)
    }

    @Test
    fun getDefaultTableNameFromDataObjectAnnotation(){
        assertEquals(
            TableNameInfo().getTableNameFromDataObjectAnnotation(TestDataObjectWithoutTableName::class as KClass<DataObject>),
            "${TestDataObjectWithoutTableName::class.simpleName!!.lowercase()}s"
        )
    }

    companion object {
        const val tablename = "tablename"
    }

    @DataObject(tablename)
    class TestDataObjectWithTableName

    @DataObject
    class TestDataObjectWithoutTableName
}