package com.myapp.repositories
import com.myapp.models.MuscleGroup
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface MuscleGroupRepository : CrudRepository<MuscleGroup?, String?>