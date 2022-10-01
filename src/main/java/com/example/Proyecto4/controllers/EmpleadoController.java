package com.example.Proyecto4.controllers;

import com.example.Proyecto4.entities.Empleado;
import com.example.Proyecto4.entities.Empresa;
import com.example.Proyecto4.responses.MessageResponse;
import com.example.Proyecto4.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService service;

    @GetMapping("empleados")
    public String selectAll(Model users){
        List <Empleado> empleadosDB = service.selectAll();
        users.addAttribute("empleados",empleadosDB);
        return "Empleado/empleados";
    }


    @GetMapping("crear")
    public String crear(){

        return "Empleado/crearempleado";
    }

    @PostMapping("crearempleado")
    public RedirectView create (Empleado data){
        MessageResponse response= service.createEmployed(data);
        return  new RedirectView("/empleado/empleados");
    }

    @PostMapping("editar")
    public MessageResponse updateEmployed(@RequestBody Empleado empleado){
        return service.updateEmployed(empleado);
    }
    @GetMapping("eliminar/{username}")
    public MessageResponse deleteEmployed(@PathVariable String username){
        return service.deleteEmployed(username);
    }




}
