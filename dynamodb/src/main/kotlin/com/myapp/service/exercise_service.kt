package com.myapp.service

import com.myapp.exceptions.NotFoundExceptions
import com.myapp.models.Exercise
import com.myapp.models.MuscleGroup
import com.myapp.repositories.*
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class ExercisesService {
    @Autowired
    private lateinit var exerciseRepository: ExerciseRepository
    @Autowired
    private lateinit var equipmentRepository: EquipmentRepository
    @Autowired
    private lateinit var levelRepository: LevelRepository
    @Autowired
    private lateinit var modalityRepository: ModalityRepository
    @Autowired
    private lateinit var muscleRepository: MuscleRepository
    @Autowired
    private lateinit var groupRepository: MuscleGroupRepository

    fun getExerciseById(id: String?): Exercise {
        val exercise: Optional<Exercise?> = exerciseRepository!!.findById(id!!)
        if (exercise.isPresent) {
            return exercise.get()
        }
        throw NotFoundExceptions("Cant find exercise with that id")
    }

    fun createMuscleGroup(muscleGroup: MuscleGroup?): MuscleGroup? {
        val uniqueID = UUID.randomUUID().toString()
        muscleGroup!!.id = uniqueID
        return groupRepository!!.save(muscleGroup!!)
    }


}