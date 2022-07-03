package com.myapp.service

import com.myapp.dtos.CreateExerciseRequest
import com.myapp.exceptions.NotFoundExceptions
import com.myapp.models.*
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


    fun handleRequests(requests: List<CreateExerciseRequest>): Array<Any> {
        for (req in requests) {
            createExercise(req)
        }
        return emptyArray()
    }

    fun createExercise(exerciseRequest: CreateExerciseRequest?): Array<Any> {

        //create data
        var level = Level()
        level.id=UUID.randomUUID().toString()
        level.name=exerciseRequest!!.level

        var modality = Modality()
        modality.id=UUID.randomUUID().toString()
        modality.name=exerciseRequest!!.modality


        levelRepository.save(level)
        modalityRepository.save(modality)

        var exercise = Exercise()
        exercise.id=exerciseRequest.id
        exercise.name=exerciseRequest.name
        exercise.levelId = level.id
        exercise.modalityId = modality.id



        var auxMuscleGroup = MuscleGroup(
//            id = UUID.randomUUID().toString(),
//            name = "AuxMuscles",
        )
        auxMuscleGroup.id=UUID.randomUUID().toString()
//        auxMuscleGroup.exerciseId=exerciseRequest.id
////        auxMuscleGroup.muscles=exerciseRequest.muscles
        auxMuscleGroup.name = "AuxMuscles"

        var minMuscleGroup = MuscleGroup(
//            id = UUID.randomUUID().toString(),
//            name = "MinMuscles",
        )
        minMuscleGroup.id=UUID.randomUUID().toString()
//        minMuscleGroup.exerciseId=exerciseRequest.id
////        minMuscleGroup.muscles=exerciseRequest.muscles
        minMuscleGroup.name="MinMuscles"

        groupRepository.saveAll(arrayListOf(auxMuscleGroup, minMuscleGroup))

        //add muscles to muscle group(Aux)
        for (aux in exerciseRequest.auxMuscles) {
            val muscle = Muscle()
            muscle.id= UUID.randomUUID().toString()
            muscle.muscleGroupId=auxMuscleGroup.id
            muscle.exerciseId=null
            muscle.name=aux
            muscleRepository.save(muscle)
        }

        //add muscles to muscle group(Min)
        for (min in exerciseRequest.minMuscles) {
            val muscle = Muscle()
            muscle.id= UUID.randomUUID().toString()
            muscle.muscleGroupId=minMuscleGroup.id
            muscle.exerciseId=null
            muscle.name=min


            muscleRepository.save(muscle)
        }


        //add muscles to exercise
        for (musc in exerciseRequest.muscles) {
            val muscle = Muscle()
            muscle.id = UUID.randomUUID().toString()
            muscle.muscleGroupId=null
            muscle.exerciseId=exerciseRequest.id
            muscle.name=exerciseRequest.name
            muscleRepository.save(muscle)
        }

        //add equipment to exercise
        for (equip in exerciseRequest.equipment) {
            val equipment = Equipment()
            equipment.id=UUID.randomUUID().toString()
            equipment.exerciseId=exerciseRequest.id
            equipment.name=equip
            equipmentRepository.save(equipment)
        }

        exerciseRepository.save(exercise)


        return arrayOf(exerciseRepository.save(exercise))


    }


}