package com.petkingdom.business;

import com.petkingdom.model.ActionLog;

import java.util.Stack;

public class HistoryManagement {
    private static Stack<ActionLog> historyStack = new Stack<>();
    public static void pushAction(String message) {
        historyStack.push(new ActionLog(message));
    }

    public boolean isEmpty() {
        return historyStack.isEmpty();
    }

    public void undo() {
        ActionLog lastAction = historyStack.peek();
        System.out.println("Hoàn tác hành động gần nhất: " + lastAction);
    }

    public void displayHistory() {
        System.out.println("--- NHẬT KÝ HOẠT ĐỘNG (Mới nhất đến cũ nhất) ---");
        for (int i = historyStack.size() - 1; i >= 0; i--) {
            System.out.println(historyStack.get(i));
        }
    }
}
