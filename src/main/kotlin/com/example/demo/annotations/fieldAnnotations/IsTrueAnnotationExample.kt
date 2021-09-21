package com.example.demo.annotations.fieldAnnotations

import com.example.demo.annotations.ClassWithBoolean

class IsTrueAnnotationExample {
    fun runIsTrueValidator(){
        val validator = IsTrueAnnotationValidator()
        println(validator.validate(ClassWithBoolean()))
        val trueClass = ClassWithBoolean()
        trueClass.areYouSerious = true
        println(validator.validate(trueClass))
    }
}