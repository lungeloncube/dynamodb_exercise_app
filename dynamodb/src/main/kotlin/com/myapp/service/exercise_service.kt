package com.myapp.service

import com.myapp.exceptions.NotFoundExceptions
import com.myapp.models.Exercise
import com.myapp.repositories.*
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class ExercisesService {
    private val exerciseRepository: ExerciseRepository?=null
    private val equipmentRepository: EquipmentRepository? = null
    private val levelRepository: LevelRepository? = null
    private val modalityRepository: ModalityRepository? = null
    private val muscleRepository: MuscleRepository? = null
    private val groupRepository: GroupRepository? = null
    fun getExerciseById(id: String?): Exercise {
        val exercise: Optional<Exercise?> = exerciseRepository!!.findById(id!!)
        if (exercise.isPresent) {
            return exercise.get()
        }
        throw NotFoundExceptions("Cant find any book under given ID")
    }


}