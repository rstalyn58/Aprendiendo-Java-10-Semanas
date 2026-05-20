package servicio;

import modelo.Contacto;
import util.ManejadorJSON;

import java.util.ArrayList;
import java.util.List;

public class GestorContactos {

    private List<Contacto> contactos;
    private ManejadorJSON manejadorJSON;
    public GestorContactos(String rutaArchivo) {
        this.manejadorJSON = new ManejadorJSON(rutaArchivo);
        this.contactos = new ArrayList<>(manejadorJSON.cargarContactos());
    }
    public void agregar(Contacto contacto) {
        contactos.add(contacto);
        manejadorJSON.guardarContactos(contactos);
    }
    public List<Contacto> listar() {
        return contactos;
    }
    public Contacto buscar(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
    public boolean eliminar(String nombre) {
        Contacto contacto = buscar(nombre);

        if (contacto != null) {
            contactos.remove(contacto);
            manejadorJSON.guardarContactos(contactos);
            return true;
        }

        return false;
    }
}