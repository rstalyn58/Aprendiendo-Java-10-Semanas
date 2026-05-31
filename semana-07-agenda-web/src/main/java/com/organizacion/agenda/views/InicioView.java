package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class InicioView extends VerticalLayout {

    public InicioView() {

        H2 titulo = new H2("Agenda de Contactos");

        Paragraph descripcion = new Paragraph(
  
        );

        RouterLink link = new RouterLink("Ver contactos", ContactosView.class);

        add(titulo, descripcion, link);
    }
}