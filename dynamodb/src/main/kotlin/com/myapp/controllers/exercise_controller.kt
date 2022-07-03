package com.myapp.controllers

import com.myapp.dtos.Root
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
    fun getExerciseById(@PathVariable exerciseId: String?): ResponseEntity<Exercise>? {
        return ResponseEntity.ok(exercisesService.getExerciseById(exerciseId))
    }

    @PostMapping("/exercises")
    fun createExercise(@RequestBody exerciseRequest: Root): ResponseEntity<Any>{

        """
            [
               {
                  "Id":"d2VpZ2h0ZWRsdW5nZXM=",
                  "Name":"Weighted Lunges",
                  "Level":"Average",
                  "Type":null,
                  "Class":"Lunges",
                  "Mechanics":null,
                  "Modality":"W",
                  "Equipment":[
                     "Barbell plate"
                  ],
                  "Alt Equipment":null,
                  "Muscles":[
                     "Glutes",
                     "Hamstrings",
                     "Quadriceps"
                  ],
                  "Aux Muscles":[
                     "Calves",
                     "Glutes",
                     "Lower Back"
                  ],
                  "Min Muscles":[
                     "Abdominals",
                     "Hip Flexor"
                  ],
                  "Alt Exercise":null,
                  "Link":"https:\/\/www.youtube.com\/embed\/ZPoMxOrIeO4"
               }
            ]
        """.trimIndent()

        val exerciseCreated: Array<Any> = exercisesService.handleRequests(exerciseRequest)
        return ResponseEntity.ok(exerciseCreated)
    }
}
