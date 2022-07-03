package com.myapp.controllers

import com.myapp.dtos.ExerciseResponse
import com.myapp.dtos.Root

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
    fun getExerciseById(@PathVariable exerciseId: String?): ResponseEntity<ExerciseResponse> {
        val exercise = exercisesService.getExerciseById(exerciseId)
        val levelId = exercise.levelId
        val level=exercisesService.getLevelById(levelId)
        val modalityId=exercise.modalityId
        val modality=exercisesService.getModalityById(modalityId)

        val muscles=exercisesService.getAllMuscles(exerciseId)


        return ResponseEntity.ok(ExerciseResponse(
            id = exercise.id!!, name =exercise.name!!,
            level =level.name!!, modality =modality.name!!,
            muscles =muscles, type = exercise.exerciseType!!,
            class_field = exercise.exerciseClass!!,
            altExercise = exercise.altExercise!!, altEquipment = exercise.altEquipment!!,
            link = exercise.link!!,mechanics=exercise.mechanics!!
        ))
    }
//    @GetMapping("/muscle/{exerciseId}")
//    fun getMuscleById(@PathVariable exerciseId: String?) :ResponseEntity<List<Muscle>>{
//        val muscle=exercisesService.getMuscleByExerciseId(exerciseId)
//        return ResponseEntity.ok(muscle)
//
//
//    }

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
