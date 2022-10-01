package com.example.Proyecto4.entities;

import javax.persistence.*;

@Entity
@Table(name = "MovimientoDinero" )
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "montoMovimiento")
    private float montoMovimiento;
    @Column(name = "conceptoMovimiento")
    private String conceptoMovimiento;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Empleado usuario;


    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
