package com.example.Proyecto4.entities;

import com.example.Proyecto4.dto.RolEmpleado;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;
    @Column(name = "correo", unique = true)
    private String correo;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password")
    private String password;


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
