package com.example.demo.services;

import com.example.demo.entities.Marca;
import com.example.demo.entities.MarcaFavorita;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MarcasService {

    private final RestTemplate cliente = new RestTemplate();
    private final List<MarcaFavorita> favoritas = new ArrayList<>();

    public List<Marca> getMarcas() {
        Marca[] marcas = cliente.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", Marca[].class);
        return Arrays.asList(marcas);
    }

    public Marca findMarcaByCodigo(String codigo) {
        Marca[] marcas = cliente.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", Marca[].class);
        for (Marca marca : marcas) {
            if (marca.getCodigo().equals(codigo)) {
                return marca;
            }
        }
        return null;
    }

    public void salvarMarca(MarcaFavorita marca) {
        favoritas.add(marca);
    }

    public List<MarcaFavorita> listarFavoritas() {
        return favoritas;
    }
}
