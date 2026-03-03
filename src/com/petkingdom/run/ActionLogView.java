package com.petkingdom.run;

import java.util.Scanner;

public class ActionLogView {
    public static void showMenu(Scanner sc){
        int choice;
        do {
            System.out.println("""
                    +------------MENU------------+
                    |1. Danh sách hành động      |
                    |2. Hoàn tác                 |
                    |3. Thoát                    |
                    +----------------------------+
                    """);
            System.out.print("Lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    displayLog();
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }while(choice != 3);
    }

    public static void displayLog(){
        if(Main.historyManagement.isEmpty()){
            System.out.println("Nhật ký trống!");
            return;
        }
        Main.historyManagement.displayHistory();
    }

    public static void undo(){
        if(Main.historyManagement.isEmpty()){
            System.out.println("Nhật ký trống!");
            return;
        }
        Main.historyManagement.undo();
    }
}
