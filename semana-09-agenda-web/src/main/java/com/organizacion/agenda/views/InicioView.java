package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Inicio")
@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    public InicioView() {

        H1 titulo =
                new H1("Agenda Web");

        Paragraph descripcion =
                new Paragraph(
                        "Bienvenido a la agenda de contactos. " +
                        "Usa el menu para navegar."
                );

        add(titulo, descripcion);

        setSpacing(true);
        setPadding(true);
    }
}