package com.myapp.controllers

import com.myapp.models.Exercise
import com.myapp.service.ExercisesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping()
class ExercisesController {
    @Autowired
    private lateinit var exercisesService: ExercisesService



    @GetMapping("/exercise/{exerciseId}")
    fun getExercise(@PathVariable exerciseId: String?): ResponseEntity<Exercise>? {
        return ResponseEntity.ok(exercisesService!!.getExerciseById(exerciseId))
    }
}
