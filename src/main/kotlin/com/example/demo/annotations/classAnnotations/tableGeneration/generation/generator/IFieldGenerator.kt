package com.example.demo.annotations.classAnnotations.tableGeneration.generation.generator

import com.example.demo.annotations.classAnnotations.tableGeneration.generation.meta.FieldMeta

interface IFieldGenerator {
    fun generate(fieldMeta: FieldMeta): String
}