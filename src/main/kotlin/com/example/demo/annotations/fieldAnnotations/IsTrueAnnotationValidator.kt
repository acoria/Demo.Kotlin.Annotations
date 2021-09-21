package com.example.demo.annotations.fieldAnnotations

class IsTrueAnnotationValidator {

    fun validate(objectToValidate: Any): Boolean {

        val fields = objectToValidate::class.java.declaredFields
        for (field in fields) {
            field.isAccessible = true
            for (annotation in field.annotations) {
                if (!field.isAnnotationPresent(IsTrue::class.java)) return true
                return when (annotation) {
                    is IsTrue -> {
                        val fieldValue = field.get(objectToValidate)
                        fieldValue == true
                    }
                    else -> true
                }
            }
        }
        return true
    }
}