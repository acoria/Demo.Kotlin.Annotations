package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration

import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MySQLFieldGeneratorTest {

    private val testObject = MySQLFieldGenerator()
    private val mockFieldMeta = mockk<FieldMeta> {
        every { name } returns (fieldName)
        every { length } returns (fieldLength)
        every { type } returns (fieldType)
        every { autoIncrement } returns (true)
        every { nullable } returns (true)
    }

    companion object {
        const val fieldName = "FieldName"
        const val fieldLength = 20
        val fieldType = MySQLFieldType.INT
    }

    @Test
    fun generateAutoIncrement() {
        assertTrue(generateMeta().contains(MySQLFieldGenerator.sqlAutoIncrement))
    }

    @Test
    fun generateNoAutoIncrement() {
        every { mockFieldMeta.autoIncrement } returns (false)
        assertFalse(testObject.generate(mockFieldMeta).contains(MySQLFieldGenerator.sqlAutoIncrement))
    }

    @Test
    fun generateNullable() {
        assertTrue(generateMeta().contains(MySQLFieldGenerator.sqlNullable))

    }

    @Test
    fun generateNotNullable() {
        every { mockFieldMeta.nullable } returns (false)
        assertTrue(generateMeta().contains(MySQLFieldGenerator.sqlNotNullable))
    }

    @Test
    fun generate() {

        assertEquals("`${fieldName}` ${fieldType}(${fieldLength}) ${MySQLFieldGenerator.sqlNullable} ${MySQLFieldGenerator.sqlAutoIncrement}", generateMeta())

        verify { mockFieldMeta.name }
        verify { mockFieldMeta.length }
        verify { mockFieldMeta.type }
        verify { mockFieldMeta.autoIncrement }
        verify { mockFieldMeta.nullable }
    }

    private fun generateMeta(): String{
        return testObject.generate(mockFieldMeta)
    }
}