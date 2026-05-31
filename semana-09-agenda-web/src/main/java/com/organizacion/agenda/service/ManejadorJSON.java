package com.organizacion.agenda.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.organizacion.agenda.modelo.Contacto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {

    private final String rutaArchivo;
    private final ObjectMapper mapper;

    public ManejadorJSON(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.mapper = new ObjectMapper();
    }

    public List<Contacto> cargar() {
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(
                    archivo,
                    new TypeReference<List<Contacto>>() {}
            );
        } catch (IOException e) {
            System.out.println("Error al cargar contactos.");
            return new ArrayList<>();
        }
    }

    public void guardar(List<Contacto> contactos) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(rutaArchivo), contactos);

        } catch (IOException e) {
            System.out.println("Error al guardar contactos.");
        }
    }
}