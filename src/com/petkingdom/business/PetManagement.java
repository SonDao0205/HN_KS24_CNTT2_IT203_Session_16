package com.petkingdom.business;

import com.petkingdom.model.Client;
import com.petkingdom.model.Pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PetManagement implements IManagement<Pet> {
    public static List<Pet> pets = new ArrayList<>();

    public boolean isEmpty() {
        return pets.isEmpty();
    }
    @Override
    public boolean add(Pet item) {
        Pet findPet = findById(item.getId());
        if(findPet == null){
            boolean isAdded = pets.add(item);
            if(isAdded){
                HistoryManagement.pushAction("Vừa thêm thú cưng: " + item.getName());
                return isAdded;
            }else{
                return false;
            }
        }
        return false;
    }

    public void displayAll() {
        System.out.println("+----------------------+");
        System.out.printf("|%-5s|%-10s|%-5s|\n","ID","Name","Type");
        System.out.println("+----------------------+");
        for(Pet item : pets){
            System.out.print(item.toString());
            System.out.println("+----------------------+");
        }
    }

    @Override
    public Pet findById(String id) {
        for(Pet item : pets){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public boolean delete(String petId) {
        Pet findPet = findById(petId);
        if(findPet != null){
            pets.remove(findPet);
            HistoryManagement.pushAction("Vừa bán thú cưng: " + findPet.getName());
            return true;
        }
        return false;
    }
}
