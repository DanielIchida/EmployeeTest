package com.parameta.prueba.infraestructure.db.dao;

import com.parameta.prueba.infraestructure.db.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity,Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.document = :document")
    Optional<EmployeeEntity> findByDocument(@Param("document") String document);

}
