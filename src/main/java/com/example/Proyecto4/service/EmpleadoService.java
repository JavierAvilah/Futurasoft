package com.example.Proyecto4.service;

import com.example.Proyecto4.entities.Empleado;
import com.example.Proyecto4.excepciones.ExcepcionApp;
import com.example.Proyecto4.repository.EmpleadoRepository;
import com.example.Proyecto4.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public List <Empleado> selectAll(){
        return repository.findAll();
    }

    public Empleado findByUsername(String username) throws ExcepcionApp {

        if (!repository.findByCorreo(username).isPresent()){
            throw new ExcepcionApp("Usuario no existe");
        }

        Empleado empleado = repository.findByCorreo(username).get();
        return empleado;
    }

    public MessageResponse createEmployed(Empleado empleado){

        MessageResponse response = new MessageResponse();

        if (empleado.getCorreo() == null || empleado.getCorreo().equals("")){
            response.setCodigo(500);
            response.setMensaje("Debe indicar un correo electronico");
            return response;
        }

        repository.save(empleado);
        response.setCodigo(200);
        response.setMensaje("Empleado registrado correctamente");
        return response;

    }

    public MessageResponse updateEmployed(Empleado empleado){

        MessageResponse response = new MessageResponse();

        if (empleado.getCorreo() == null || empleado.getCorreo().equals("")){
            response.setCodigo(500);
            response.setMensaje("Debe indicar un correo electronico");
            return response;
        }

        if (!repository.findByCorreo(empleado.getCorreo()).isPresent()){
            response.setCodigo(500);
            response.setMensaje("El usuario no existe");
            return response;
        }

        Empleado edit = repository.findByCorreo(empleado.getCorreo()).get();

        edit.setNombreEmpleado(empleado.getNombreEmpleado());
        edit.setEmpresa(edit.getEmpresa());
        repository.save(edit);
        response.setCodigo(200);
        response.setMensaje("Empleado editado correctamente");
        return response;
    }
    public MessageResponse deleteEmployed(String username){
        MessageResponse response = new MessageResponse();


        repository.deleteByCorreo(username);
        response.setCodigo(200);
        response.setMensaje("Empleado eliminado correctamente");
        return response;
    }

}
