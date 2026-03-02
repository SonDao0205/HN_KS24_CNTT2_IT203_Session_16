package com.petkingdom.run;

import com.petkingdom.business.PetManagement;
import com.petkingdom.business.ServiceManagement;

import java.util.Scanner;

public class Main {
    public static PetManagement petManagement = new PetManagement();
    public static ServiceManagement serviceManagement = new ServiceManagement();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
        sc.close();
    }

    public static void run(Scanner sc){
        View.showMenu(sc);
    }
}
