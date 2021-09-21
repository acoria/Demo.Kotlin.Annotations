package com.example.demo.annotations.classAnnotations.tableGeneration.meta

class TableMeta(
    val name: String,
    val fieldMetas: List<FieldMeta>,
) {
    val primaryKeyFieldMetas = findPrimaryKeyFieldMetas()

    private fun findPrimaryKeyFieldMetas(): List<FieldMeta> {
        val fieldMetas = fieldMetas.filter { dbField -> dbField.isPrimaryKey }
        if (fieldMetas.isEmpty()) {
            throw RuntimeException("No primary key defined")
        }
        return fieldMetas
    }
}
