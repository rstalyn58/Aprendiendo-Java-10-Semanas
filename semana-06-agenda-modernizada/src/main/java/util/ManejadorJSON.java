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

    private final String ruta;
    private final Gson gson = new Gson();

    public ManejadorJSON(String ruta) {
        this.ruta = ruta;
    }
    public List<Contacto> leer() {
        try (FileReader reader = new FileReader(ruta)) {
            Type tipoLista = new TypeToken<List<Contacto>>() {}.getType();
            List<Contacto> contactos = gson.fromJson(reader, tipoLista);
            return contactos != null ? contactos : new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void guardar(List<Contacto> contactos) {
        try (FileWriter writer = new FileWriter(ruta)) {
            gson.toJson(contactos, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    public List<Contacto> cargarContactos() {
        return leer();
    }

    public void guardarContactos(List<Contacto> contactos) {
        guardar(contactos);
    }
}