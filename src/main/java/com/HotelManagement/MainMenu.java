package com.HotelManagement;

import java.util.Scanner;

class MainMenu {
    public void manager(Scanner sc){
        System.out.println("\nMain Menu\n");

        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Remove User");
        System.out.println("4. Check booked Room");
        System.out.println("5. Check Unbooked Room");
        System.out.println("6. Total Employee");
        System.out.println("7. Exit");

        int n = 0;
        try{
            n = sc.nextInt();
        }
        catch(Exception e){
            System.out.println("\nEnter valid details!\n");
        }

        switch(n){
            case 1 : 
                break;
            
            case 2 : 
                break;

            case 3 : 
                break;

            case 4 : 
                break;

            case 5 : 
                break;

            case 6 : 
                break;

            case 7 : 
                break;

            default : 
        }
    }

    public void user(Scanner sc){
        System.out.println("\nMain Menu\n");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Remove User");
        System.out.println("4. Check booked Room");
        System.out.println("5. Check Unbooked Room");
        System.out.println("6. Total Employee");
        System.out.println("7. Exit");

        int n = 0;
        try{
            n = sc.nextInt();
        }
        catch(Exception e){
            System.out.println("\nEnter valid details!\n");
        }

        switch(n){
            case 1 : 
                break;
            
            case 2 : 
                break;

            case 3 : 
                break;

            case 4 : 
                break;

            case 5 : 
                break;

            case 6 : 
                break;

            case 7 : 
                break;

            default : 
        }
    }
}
