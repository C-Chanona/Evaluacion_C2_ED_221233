
package com.upchiapas.pizzeria.models;

public class Pizza {
    private int idPizza;
    private String especialidad;
    private float precio;
    private static int contadorPizzas;

    public Pizza() {
    }

    public Pizza(String especialidad, float precio) {
        this.especialidad = especialidad;
        this.precio = precio;
        this.idPizza = ++contadorPizzas; // inicia desde 0
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza{");
        sb.append("idPizza=").append(idPizza);
        sb.append(", especialidad=").append(especialidad);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    
    
}
