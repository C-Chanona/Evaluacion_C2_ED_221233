
package com.upchiapas.pizzeria.models;

import java.util.ArrayList;
import java.util.Scanner;

public class OrdenCompra {

    private byte idOrdenCompra;
    private ArrayList<ItemCompra> productosItem;
    private Cliente cliente;
    private static byte contadorOrdenCompra;

    public OrdenCompra() {
        productosItem = new ArrayList<>();
        this.idOrdenCompra = ++contadorOrdenCompra;
    }

    public void insertarItemCompra(CatalogoPizza catalogo) {
        Scanner consola = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 2) {
            System.out.println("¿Qué especialidad quieres?");
            var pizza = catalogo.seleccionarEspecialidad();
            System.out.println("¿Cuántas quieres?");
            var cantidad = Byte.parseByte(consola.nextLine());
            var subtotal = pizza.getPrecio() * cantidad;
            System.out.println("El subtotal de estos elementos son de: " + subtotal);
            ItemCompra item = new ItemCompra(cantidad, pizza, subtotal);

            productosItem.add(item);
            System.out.println("¿Quieres añadir otro? Responde 1 para si, 2 para no");
            
            opcion = Integer.parseInt(consola.nextLine());
        }
        
    }

    public byte getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public ArrayList<ItemCompra> getProductosItem() {
        return productosItem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
