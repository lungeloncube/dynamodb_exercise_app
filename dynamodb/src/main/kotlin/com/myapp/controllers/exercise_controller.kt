package com.myapp.controllers

import com.myapp.models.Exercise
import com.myapp.models.MuscleGroup
import com.myapp.service.ExercisesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping()
class ExercisesController {
    @Autowired
    private lateinit var exercisesService: ExercisesService



    @GetMapping("/exercise/{exerciseId}")
    fun getExercise(@PathVariable exerciseId: String?): ResponseEntity<Exercise>? {
        return ResponseEntity.ok(exercisesService!!.getExerciseById(exerciseId))
    }

    @PostMapping("/exercise")
    fun createExercise(@RequestBody muscleGroup: MuscleGroup): ResponseEntity<MuscleGroup>{
        val exerciseCreated: MuscleGroup? = exercisesService!!.createMuscleGroup(muscleGroup)
        return ResponseEntity.ok(exerciseCreated)
    }
}
