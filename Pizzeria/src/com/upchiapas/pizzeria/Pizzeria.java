
package com.upchiapas.pizzeria;

import com.upchiapas.pizzeria.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {

    public static void main(String[] args) {
        ArrayList<Cliente> listadoClientes = new ArrayList<>();
        ArrayList<OrdenCompra> ordenesCompra = new ArrayList<>();
        CatalogoPizza catalogo = new CatalogoPizza();
        Scanner consola = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("Flamingo's Pizza");
            System.out.println("Inserte la opción que desee \n"
                    + "1.- Crear clientes\n"
                    + "2.- Crear especialidad\n"
                    + "3.- Listar clientes\n"
                    + "4.- Listar especialidades\n"
                    + "5.- Crear orden de compra\n"
                    + "6.- Reportes de venta\n"
                    + "7.- Ordenar Alfabeticamente\n"
                    + "8.- Salir");
            opcion = Integer.parseInt(consola.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuál es el nombre del cliente?");
                    String nombre = consola.nextLine();
                    System.out.println("¿Dirección?");
                    String direccion = consola.nextLine();
                    System.out.println("¿Teléfono?");
                    String telefono = consola.nextLine();

                    listadoClientes.add(new Cliente(nombre, direccion, telefono));
                    break;

                case 2:
                    System.out.println("¿Cuál es el nombre de la especialidad?");
                    String especialidad = consola.nextLine();
                    System.out.println("¿Cuál es el precio?");
                    float precio = Float.parseFloat(consola.nextLine());
                    catalogo.insertarPizza(new Pizza(especialidad, precio));
                    break;
                case 3:
                    Cliente.imprimirListadoClientes(listadoClientes);
                    break;
                case 4:
                    catalogo.imprimirCatalogo();
                    break;
                case 5:
                    OrdenCompra orden = new OrdenCompra();
                    orden.insertarItemCompra(catalogo);
                    System.out.println("¿A nombre de quién quedará la compra?");
                    orden.setCliente(Cliente.seleccionarCliente(listadoClientes));
                    ordenesCompra.add(orden);
                    break;
                case 6:
                    String infoVenta = "";

                    //de lado izquierdo es el elemento en singular y el lado derecho el listado de donde voy recorrer mis elementos
                    for (OrdenCompra ord : ordenesCompra) {
                        infoVenta += "Compra #" + ord.getIdOrdenCompra() + " Items:\n";
                        float totalCompra = 0;
                        for(ItemCompra ordItem: ord.getProductosItem()){
                            infoVenta += "Especialidad: " +ordItem.getProducto().getEspecialidad() + "\t" + "Precio unitario: " + ordItem.getProducto().getPrecio() + "\t" + "Cantidad: " + ordItem.getCantidad() + "\t" + "Subtotal: " + ordItem.getSubtotal() + "\n";
                            totalCompra += ordItem.getSubtotal();
                        }
                        infoVenta += "Total de compra #" + ord.getIdOrdenCompra() + ": " + totalCompra + "\n";
                        infoVenta += "Cliente: " + ord.getCliente().getNombre() + "\n";
                    }

                    System.out.println(infoVenta);
                    break;
                case 7:
                    listadoClientes = Cliente.OrdenarAlfabeticamente(listadoClientes);
                    break;
                case 8:
                    System.out.println("Hasta pronto");
                break;
                default:
                    throw new AssertionError();
            }
        }
    }

}
