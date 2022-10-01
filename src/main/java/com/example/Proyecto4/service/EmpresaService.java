package com.example.Proyecto4.service;

import com.example.Proyecto4.entities.Empresa;
import com.example.Proyecto4.excepciones.ExcepcionApp;
import com.example.Proyecto4.repository.EmpresaRepository;
import com.example.Proyecto4.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    public List<Empresa> selectAll(){
        return repository.findAll();
    }

    public Empresa findBynit(String nit) throws ExcepcionApp {

        if (!repository.findByNit(nit).isPresent()){
            throw new ExcepcionApp("Usuario no existe");
        }

        Empresa empresa = repository.findByNit(nit).get();
        return empresa;
    }

    public MessageResponse createCompany(Empresa empresa){

        MessageResponse response = new MessageResponse();

        if (empresa.getNit() == null || empresa.getNit().equals("")){
            response.setCodigo(500);
            response.setMensaje("Debe indicar el nit");
            return response;
        }

        repository.save(empresa);
        response.setCodigo(200);
        response.setMensaje("Empresa registrado correctamente");
        return response;

    }

    public MessageResponse updateCompany(Empresa empresa){

        MessageResponse response = new MessageResponse();

        if (empresa.getNit() == null || empresa.getNit().equals("")){
            response.setCodigo(500);
            response.setMensaje("Debe indicar el nit");
            return response;
        }

        if (!repository.findByNit(empresa.getNit()).isPresent()){
            response.setCodigo(500);
            response.setMensaje("El usuario no existe");
            return response;
        }

        Empresa edit = repository.findByNit(empresa.getNit()).get();

        edit.setNombre(empresa.getNombre());
        edit.setTelefono(empresa.getTelefono());
        edit.setDireccion(empresa.getDireccion());
        repository.save(edit);
        response.setCodigo(200);
        response.setMensaje("Empresa editado correctamente");
        return response;
    }
    public MessageResponse deleteConmpany(String nit){
        MessageResponse response = new MessageResponse();

        repository.deleteByNit(nit);
        response.setCodigo(200);
        response.setMensaje("Empresa eliminada correctamente");
        return response;
    }

    public Empresa gerEmpresa(int id){
        Optional<Empresa> empresa = repository.findById(id);
        if (empresa.isPresent()){
            return empresa.get();
        }else {return null;}
    }
    public MessageResponse deleteCompanybyId(int id){
        MessageResponse response = new MessageResponse();
        repository.deleteById(id);
        response.setCodigo(200);
        response.setMensaje("Empresa eliminada correctamente");
        return response;
    }
}
