package com.upchiapas.pizzeria.models;

import java.util.ArrayList;

//Heredando Comparable
public class Sort <T extends Comparable<T>> {

    public ArrayList<Cliente> insercion ( ArrayList<Cliente> array){
        Cliente aux;
        for (int i = 1; i < array.size(); i++){
            aux = array.get(i);
            for (int j = i-1; j >= 0 && array.get(j).getNombre().compareTo(aux.getNombre()) > 0; j--) {
                array.set(j+1, array.get(j));
                array.set(j,aux);

            }
            
        }

        return array;
    }
}
