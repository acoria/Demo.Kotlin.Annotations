package com.example.demo.annotations.classAnnotations.tableGeneration.generation.generator

interface ITableGenerator {
    fun generateCreateTable()
    fun generateFields()
    fun generatePrimaryKey()
    fun generate(): String
}