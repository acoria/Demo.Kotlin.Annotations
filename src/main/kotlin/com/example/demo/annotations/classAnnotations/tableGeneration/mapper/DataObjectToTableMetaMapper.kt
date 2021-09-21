package com.example.demo.annotations.classAnnotations.tableGeneration.mapper

import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.annotations.DataObject
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.IToTableMetaMapper
import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.TableMeta
import com.example.demo.annotations.classAnnotations.tableGeneration.dataObjectRealted.tableInfo.TableNameInfo
import kotlin.reflect.KClass

class DataObjectToTableMetaMapper(private val dataObjectKClass: KClass<DataObject>) : IToTableMetaMapper {

    private val fieldMetas: List<FieldMeta> = createFieldMetasFromDataObject()

    private fun createTableMeta(): TableMeta {
        return TableMeta(TableNameInfo().getTableNameFromDataObjectAnnotation(dataObjectKClass), fieldMetas)
    }

    private fun createFieldMetasFromDataObject(): List<FieldMeta> {
        val fieldMetas = mutableListOf<FieldMeta>()
        val propertyToFieldMetaMapper = PropertyToFieldMetaMapper()
        dataObjectKClass.java.declaredFields.forEach {
            fieldMetas.add(propertyToFieldMetaMapper.map(it))
        }
        return fieldMetas
    }

    override fun map(): TableMeta {
        return createTableMeta()
    }
}