package com.example.Proyecto4.repository;

import com.example.Proyecto4.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository <MovimientoDinero,Long> {
}
