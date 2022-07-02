package com.upchiapas.pizzeria.models;

import java.util.ArrayList;
import java.util.Scanner;
public class Cliente {

    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private static int contadorClientes;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCliente = ++contadorClientes; // La id se asigna automáticamente cada vez que creemos un objeto de tipo cliente
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static void imprimirListadoClientes(ArrayList<Cliente> lista){
        String info = "";

        //var se usa para inferencia de tipos
        for (Cliente c : lista) {
            info += "ID: " + c.getIdCliente() + "\t" + "Nombre: " + c.getNombre() + "\t" + "Dirección: " + c.getDireccion() + "\t" + "Teléfono" + c.getTelefono() + "\n";
        }

        System.out.println(info);
    }

    public static ArrayList<Cliente> OrdenarAlfabeticamente(ArrayList<Cliente> OrdenAlfa)
    {
        Sort ordenar = new Sort();

        OrdenAlfa = ordenar.insercion(OrdenAlfa);

        for (int i = 0; i < OrdenAlfa.size(); i++) {
            Cliente element = OrdenAlfa.get(i);
            System.out.println(element.toString());
        }

        return OrdenAlfa;
    }
    public static Cliente seleccionarCliente(ArrayList<Cliente> lista) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Elija el ID del cliente a quien quedará la orden");
        Cliente.imprimirListadoClientes(lista);
        int opcion = Integer.parseInt(consola.nextLine());

        return lista.get(opcion - 1); // menos 1 porque visualmente la id es 1, pero en arreglo es 0
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

}
