package servicio;

import modelo.Contacto;
import util.ManejadorJSON;
import excepcion.ContactoExistenteException;
import excepcion.ContactoNoEncontradoException;

import java.util.List;

public class AgendaContactos {

    private List<Contacto> contactos;

    public AgendaContactos() {
        contactos = ManejadorJSON.leerContactos();
    }

    public void agregarContacto(Contacto contacto) throws ContactoExistenteException {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre())) {
                throw new ContactoExistenteException("El contacto ya existe");
            }
        }

        contactos.add(contacto);
        ManejadorJSON.guardarContactos(contactos);
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }

    public Contacto buscarContacto(String nombre) throws ContactoNoEncontradoException {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }

        throw new ContactoNoEncontradoException("Contacto no encontrado");
    }

    public void eliminarContacto(String nombre) throws ContactoNoEncontradoException {
        Contacto eliminado = null;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                eliminado = c;
                break;
            }
        }

        if (eliminado == null) {
            throw new ContactoNoEncontradoException("No se puede eliminar, no existe");
        }

        contactos.remove(eliminado);
        ManejadorJSON.guardarContactos(contactos);
    }
}