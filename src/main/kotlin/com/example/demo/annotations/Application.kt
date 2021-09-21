package com.example.demo.annotations

import com.example.demo.annotations.classAnnotations.FindAllClassesWithAnnotationExample
import com.example.demo.annotations.classAnnotations.tableGeneration.environmentCreator.EnvironmentCreator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    @Bean
    fun run() {
//		IsTrueAnnotationExample().runIsTrueValidator()
//		FindAllClassesWithAnnotationExample().run()
        EnvironmentCreator().create()
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
