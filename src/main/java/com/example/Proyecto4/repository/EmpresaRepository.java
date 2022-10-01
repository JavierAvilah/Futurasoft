package com.example.Proyecto4.repository;

import com.example.Proyecto4.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa,Integer> {
    Optional<Empresa> findByNit(String nit);

    void deleteByNit(String nit);

}
