package com.example.demo.controller;


import com.example.demo.entities.Marca;
import com.example.demo.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class MarcasController {
    @Autowired
    private MarcasService marcasService;

    @GetMapping("/marcas")
    public List<Marca> getMarcas() {
        return marcasService.getMarcas();
    }

    @GetMapping("/marcas/{codigo}")
    public Marca findMarcaByCodigo(@PathVariable String codigo) {
        return marcasService.findMarcaByCodigo(codigo);
    }

    @GetMapping("/sobre")
    public Map<String, String> sobre() {
        return Map.of(
                "integrantes", "Patricia Morais da Silva",
                "nome do projeto", "Projeto Backend Integração de API externa(Tabela Fipe)"
        );
    }

    @PostMapping("/modelos")
    public ResponseEntity<Object> buscarModelosPorMarca(@RequestBody Marca.MarcaRequest request) {
        String codigo = request.getCodigo();
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codigo + "/modelos";

        RestTemplate restTemplate = new RestTemplate();
        Object resposta = restTemplate.getForObject(url, Object.class);

        return ResponseEntity.ok(resposta);
    }
}

