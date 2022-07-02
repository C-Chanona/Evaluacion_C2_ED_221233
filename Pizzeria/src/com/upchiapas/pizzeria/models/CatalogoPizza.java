
package com.upchiapas.pizzeria.models;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoPizza {
    private ArrayList<Pizza> catalogoPizza;

    public CatalogoPizza() {
        this.catalogoPizza = new ArrayList();
    }
    
    public void insertarPizza(Pizza p){
        catalogoPizza.add(p);
    }
    
     public void imprimirCatalogo(){
         String info = "";
         
         for(Pizza p: catalogoPizza){
             info += "ID: " + p.getIdPizza() + "\t" + "Especialidad: " + p.getEspecialidad() + "\t" + "Precio: " + p.getPrecio() + "\n";
         }
         
         System.out.println(info);
     }
     
     public Pizza seleccionarEspecialidad(){
         Scanner consola = new Scanner(System.in);
         System.out.println("Elija el ID de la especialidad que guste");
         String info = "";
         
         for(Pizza p: catalogoPizza){
             info += "ID: " + p.getIdPizza() + "\t" + "Especialidad: " + p.getEspecialidad() + "\t" + "Precio: " + p.getPrecio() + "\n";
         }
         System.out.println(info);
         int opcion = Integer.parseInt(consola.nextLine());
         
         return catalogoPizza.get(opcion - 1); // menos 1 porque visualmente la id es 1, pero en arreglo es 0
     }
}
