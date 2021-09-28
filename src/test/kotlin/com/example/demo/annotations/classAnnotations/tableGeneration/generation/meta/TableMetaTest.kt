package com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TableMetaTest {

    private val mockPrimaryKeyFieldMeta1 = mockk<FieldMeta>()
    private val mockPrimaryKeyFieldMeta2 = mockk<FieldMeta>()
    private val mockFieldMeta = mockk<FieldMeta>()

    private lateinit var testObject: TableMeta

    companion object {
        const val tableName = "tableName"
    }

    @BeforeAll
    fun setup(){
        every { mockPrimaryKeyFieldMeta1.isPrimaryKey } returns (true)
        every { mockPrimaryKeyFieldMeta2.isPrimaryKey } returns (true)
        every { mockFieldMeta.isPrimaryKey } returns (false)
        val fieldMetas = listOf(mockPrimaryKeyFieldMeta1, mockPrimaryKeyFieldMeta2, mockFieldMeta)
        testObject = TableMeta(tableName, fieldMetas)
    }

    @Test
    fun getName() {
        assertEquals(testObject.name, tableName)
    }

    @Test
    fun getPrimaryKeys() {
        assertEquals(testObject.primaryKeyFieldMetas, listOf(mockPrimaryKeyFieldMeta1, mockPrimaryKeyFieldMeta2))
    }

    @Test
    fun getPrimaryKeyNoKeyException() {
        assertThrows<RuntimeException> { TableMeta(tableName, listOf(mockFieldMeta)) }
    }
}