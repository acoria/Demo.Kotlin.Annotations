package com.example.demo.annotations.classAnnotations.tableGeneration.mySQL

import com.example.demo.annotations.classAnnotations.tableGeneration.generator.IFieldGenerator
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.FieldMeta

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