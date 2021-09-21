package com.example.demo.annotations.classAnnotations.tableGeneration.mySQLGeneration

import com.example.demo.annotations.classAnnotations.tableGeneration.generation.generator.IFieldGenerator
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta

class MySQLFieldGenerator : IFieldGenerator {

    override fun generate(fieldMeta: FieldMeta): String {
        return "`${fieldMeta.name}` ${fieldMeta.type}(${fieldMeta.length}) ${generateNullable(fieldMeta)} ${
            generateAutoIncrement(
                fieldMeta
            )
        }"
    }

    private fun generateAutoIncrement(fieldMeta: FieldMeta): String {
        return if (fieldMeta.autoIncrement) {
            "AUTO_INCREMENT"
        } else {
            ""
        }
    }

    private fun generateNullable(fieldMeta: FieldMeta): String {
        return if (fieldMeta.nullable) {
            "DEFAULT NULL"
        } else {
            "NOT NULL"
        }
    }
}