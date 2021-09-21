package com.example.demo.annotations.classAnnotations.tableGeneration.mapper

import com.example.demo.annotations.classAnnotations.tableGeneration.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.FieldMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.IToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.meta.TableMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.tableInfo.TableNameInfo

class DataObjectToTableMetaMapper(private val dataObjectClass: Class<DataObject>) : IToTableMetaMapper {

    private val fieldMetas: List<FieldMeta> = createFieldMetasFromDataObject()

    private fun createTableMeta(): TableMeta {
        return TableMeta(TableNameInfo().getTableNameFromDataObject(dataObjectClass), fieldMetas)
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