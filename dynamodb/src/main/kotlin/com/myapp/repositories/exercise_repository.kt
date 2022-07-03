package com.myapp.repositories
import com.myapp.models.Exercise
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface ExerciseRepository : CrudRepository<Exercise?, String?>{
    
}