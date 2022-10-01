package com.example.Proyecto4.controllers;

import com.example.Proyecto4.entities.Empleado;
import com.example.Proyecto4.entities.Empresa;
import com.example.Proyecto4.responses.MessageResponse;
import com.example.Proyecto4.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping("empresas")
    public String empresas(Model data){
        List<Empresa> empresasDb= service.selectAll();
        data.addAttribute("empresas",empresasDb);
        return "Empresa/empresa";
    }
    @GetMapping("crear")
    public String crear(Model data){

        return "Empresa/crearempresa";
    }
    @PostMapping("crearempresa")
    public RedirectView create (Empresa data){
        MessageResponse response= service.createCompany(data);
        return  new RedirectView("/empresa/empresas");
    }
    @GetMapping("editar/{id}")
    public String editar (@PathVariable int id, Model data){
        Empresa empresa = this.service.gerEmpresa(id);
        List<Empresa> empresas =this.service.selectAll();
        data.addAttribute("empresa",empresa);
        data.addAttribute("empresas",empresas);

        return "Empresa/editempresa";
    }
    @PostMapping("editar")
    public RedirectView editar(Empresa data){
        MessageResponse response = this.service.updateCompany(data);
        System.out.println(response.getMensaje());
        return new RedirectView("/empresa/empresas");
    }
    @GetMapping("delete/{id}")
    public RedirectView delete (@PathVariable int id){
        MessageResponse response = this.service.deleteCompanybyId(id);
        return new RedirectView("/empresa/empresas");
    }


}
