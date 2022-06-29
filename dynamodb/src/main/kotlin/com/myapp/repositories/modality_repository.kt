package com.myapp.repositories
import com.myapp.models.Exercise
import com.myapp.models.Modality
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface ModalityRepository : CrudRepository<Modality?, String?>