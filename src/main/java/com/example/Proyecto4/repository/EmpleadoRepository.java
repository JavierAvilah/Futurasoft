package com.example.Proyecto4.repository;

import com.example.Proyecto4.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {
    Optional<Empleado> findByCorreo(String correo);

    long deleteByCorreo(String correo);



}
