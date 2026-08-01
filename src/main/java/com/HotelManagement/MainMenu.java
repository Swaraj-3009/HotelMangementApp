package com.HotelManagement;

import java.util.Scanner;

class MainMenu {
    public void manager(Scanner sc, Verify verify){
        System.out.println("\nMain Menu\n");

        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Add User");
        System.out.println("4. Remove User");
        System.out.println("5. Check booked Room");
        System.out.println("6. Check Unbooked Room");
        System.out.println("7. Total Employee");
        System.out.println("8. Exit");

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

            case 8 :
                break;

            default : 
        }
    }

    public void user(Scanner sc, String username, String password){
        System.out.println("\nMain Menu\n");
        System.out.println("1. Book room ");
        System.out.println("2. Order food ");
        System.out.println("3. Organise party");
        System.out.println("4. Take swimming pass");
        System.out.println("5. Book meeting hall");
        System.out.println("6. Take playzone pass");
        System.out.println("7. Take gym pass");
        System.out.println("8. Delete Account");
        System.out.println("9. Exit");

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

            case 8 :
                break;

            case 9 :
                break;

            default : 
        }
    }
}
