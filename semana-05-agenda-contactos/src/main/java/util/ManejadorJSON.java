package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {

    private static final String ARCHIVO = "data/contactos.json";
    private static final Gson gson = new Gson();

    public static List<Contacto> leerContactos() {
        try (FileReader reader = new FileReader(ARCHIVO)) {

            Type tipoLista = new TypeToken<List<Contacto>>() {}.getType();
            List<Contacto> contactos = gson.fromJson(reader, tipoLista);

            if (contactos == null) {
                return new ArrayList<>();
            }

            return contactos;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void guardarContactos(List<Contacto> contactos) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(contactos, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }
}