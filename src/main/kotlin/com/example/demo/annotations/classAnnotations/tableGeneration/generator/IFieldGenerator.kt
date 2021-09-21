package com.example.demo.annotations.classAnnotations.tableGeneration.generator

import com.example.demo.annotations.classAnnotations.tableGeneration.meta.FieldMeta

interface IFieldGenerator {
    fun generate(fieldMeta: FieldMeta): String
}