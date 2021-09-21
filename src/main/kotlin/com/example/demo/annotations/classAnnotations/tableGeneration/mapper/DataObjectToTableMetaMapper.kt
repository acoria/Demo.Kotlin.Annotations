package com.example.demo.annotations.classAnnotations.tableGeneration.mapper

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.IToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.TableMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo.TableNameInfo

class DataObjectToTableMetaMapper(private val dataObjectClass: Class<DataObject>) : IToTableMetaMapper {

    private val fieldMetas: List<FieldMeta> = createFieldMetasFromDataObject()

    private fun createTableMeta(): TableMeta {
        return TableMeta(TableNameInfo().getTableNameFromDataObjectAnnotation(dataObjectClass), fieldMetas)
    }

    private fun createFieldMetasFromDataObject(): List<FieldMeta> {
        val fieldMetas = mutableListOf<FieldMeta>()
        val propertyToFieldMetaMapper = PropertyToFieldMetaMapper()
        dataObjectClass.declaredFields.forEach {
            fieldMetas.add(propertyToFieldMetaMapper.map(it))
        }
        return fieldMetas
    }

    override fun map(): TableMeta {
        return createTableMeta()
    }
}