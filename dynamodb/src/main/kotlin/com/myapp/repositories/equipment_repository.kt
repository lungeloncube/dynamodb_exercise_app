package com.myapp.repositories
import com.myapp.models.Equipment
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface EquipmentRepository : CrudRepository<Equipment?, String?>