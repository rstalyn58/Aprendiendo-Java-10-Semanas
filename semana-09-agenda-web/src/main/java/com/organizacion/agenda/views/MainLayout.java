package com.organizacion.agenda.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {

        H2 titulo =
                new H2("Agenda Web");

        RouterLink linkInicio =
                new RouterLink(
                        "Inicio",
                        InicioView.class
                );

        RouterLink linkContactos =
                new RouterLink(
                        "Contactos",
                        ContactosView.class
                );

        HorizontalLayout menu =
                new HorizontalLayout(
                        linkInicio,
                        linkContactos
                );

        VerticalLayout contenido =
                new VerticalLayout(
                        titulo,
                        menu
                );

        addToNavbar(contenido);
    }
}