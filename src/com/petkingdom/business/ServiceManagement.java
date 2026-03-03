package com.petkingdom.business;

import com.petkingdom.model.Client;
import com.petkingdom.model.Pet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServiceManagement {
    Queue<Pet> serviceQueue = new LinkedList<>();
    public void petAdoption(Pet pet){
        serviceQueue.offer(pet);
        System.out.println("Đã thêm thú cưng vào hàng đợi! Số thứ tự : "+ serviceQueue.size());
    }

    public void serviceProcessing(){
        if(serviceQueue.isEmpty()){
            System.out.println("Hàng đợi trống!");
            return;
        }
        Pet pollPet = serviceQueue.poll();
        if(pollPet != null){
            System.out.printf("Số thứ tự : %d. Thú cưng tên : %s đang được phục vụ!\n",serviceQueue.size() + 1,pollPet.getName());
        }
    }
}