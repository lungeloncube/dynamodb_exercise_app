package com.myapp.repositories
import com.myapp.models.Muscle
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface MuscleRepository : CrudRepository<Muscle?, String?>