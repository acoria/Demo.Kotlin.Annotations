package com.example.demo.annotations.classAnnotations.tableGeneration.mySQL

import com.example.demo.annotations.classAnnotations.tableGeneration.generator.ITableGenerator
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.TableMeta
import java.lang.StringBuilder

class MySQLTableGenerator(private val tableMeta: TableMeta) : ITableGenerator {
    private lateinit var stringBuilder: StringBuilder

    override fun generateCreateTable() {
        stringBuilder.appendLine("CREATE TABLE IF NOT EXISTS `${tableMeta.name}` (")
    }

    override fun generateFields() {
        tableMeta.fieldMetas.forEach {
            stringBuilder.appendLine("${MySQLFieldGenerator().generate(it)},")
        }
    }

    override fun generatePrimaryKey() {
        val primaryKeyFieldMetas = tableMeta.primaryKeyFieldMetas
        primaryKeyFieldMetas.forEachIndexed { index, fieldMeta ->
            stringBuilder.append("PRIMARY KEY (`${fieldMeta.name}`)")
            if (index + 1 < primaryKeyFieldMetas.size) {
                stringBuilder.appendLine(",")
            }
        }
    }

    override fun generate(): String {
        stringBuilder = StringBuilder()
        generateCreateTable()
        generateFields()
        generatePrimaryKey()
        stringBuilder.appendLine(")")
        return stringBuilder.toString()
    }
}