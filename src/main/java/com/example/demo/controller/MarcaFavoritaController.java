package com.example.demo.controller;

import com.example.demo.entities.MarcaFavorita;
import com.example.demo.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaFavoritaController {

    @Autowired
    private MarcasService service;

    @PostMapping("/favorita")
    public String adicionarFavorita(@RequestBody MarcaFavorita marca) {
        service.salvarMarca(marca);
        return "Marca favorita salva com sucesso!";
    }

    @GetMapping("/favoritas")
    public List<MarcaFavorita> listarFavoritas() {
        return service.listarFavoritas();
    }
}
