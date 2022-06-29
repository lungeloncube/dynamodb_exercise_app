package com.myapp.repositories
import com.myapp.models.Level
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
interface LevelRepository : CrudRepository<Level?, String?>