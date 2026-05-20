package servicio;

import modelo.Contacto;
import excepciones.ContactoExistenteException;
import excepciones.ContactoNoEncontradoException;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorContactosTest {

    private GestorContactos gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorContactos("datos/test_contactos.json");
    }

    @Test
    void testAgregarContacto() throws ContactoExistenteException {
        Contacto c = new Contacto("Joel", "123456", "joel@email.com");

        gestor.agregar(c);

        List<Contacto> lista = gestor.listar();

        assertTrue(lista.stream()
                .anyMatch(contacto -> contacto.getNombre().equals("Joel")));
    }

    @Test
    void testNoAgregarDuplicado() throws ContactoExistenteException {
        Contacto c = new Contacto("Joel", "123456", "joel@email.com");

        gestor.agregar(c);

        assertThrows(ContactoExistenteException.class, () -> {
            gestor.agregar(c);
        });
    }

    @Test
    void testBuscarContacto() throws ContactoExistenteException {
        Contacto c = new Contacto("Ana", "999", "ana@email.com");

        gestor.agregar(c);

        Contacto encontrado = gestor.buscar("Ana");

        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNombre());
    }

    @Test
    void testEliminarContacto() throws ContactoExistenteException, ContactoNoEncontradoException {
        Contacto c = new Contacto("Luis", "888", "luis@email.com");

        gestor.agregar(c);
        gestor.eliminar("Luis");

        Contacto eliminado = gestor.buscar("Luis");

        assertNull(eliminado);
    }

    @Test
    void testEliminarNoExistente() {
        assertThrows(ContactoNoEncontradoException.class, () -> {
            gestor.eliminar("NoExiste");
        });
    }
}