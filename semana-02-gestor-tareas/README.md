# Gestor de Tareas POO

Proyecto de la Semana 2 del curso *Aprendiendo Java en 10 Semanas*.
Implementa un gestor de tareas usando Programación Orientada a Objetos.

## Funcionalidades

* CRUD de tareas
* Filtro por estado (pendiente/completada)
* Estadísticas básicas
* Menú interactivo

## Estructura

| Archivo                    | Descripción        |
| -------------------------- | ------------------ |
| Main.java                  | Menú y ejecución   |
| modelo/Tarea.java          | Entidad Tarea      |
| servicio/GestorTareas.java | Lógica del sistema |

## Ejecución

```bash
javac Main.java modelo/*.java servicio/*.java
java Main
```

## Clases

## Tarea:** id, titulo, descripcion, estado
**GestorTareas:** lista de tareas, control de operaciones

## Autor

Stalyn Joel Rodriguez Suyo
