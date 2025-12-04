package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Directory StarterDir = new Directory("Starter", 0, new Date(), new Date(), null);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File System Simulator!");
        System.out.print("");
        String fileName = scanner.nextLine();
    }
}