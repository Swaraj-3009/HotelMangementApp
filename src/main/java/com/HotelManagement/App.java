package com.HotelManagement;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();

        System.out.println("Book My Hotel");

        System.out.println("1. Login as Manager");
        System.out.println("2. Login as User");

        int n = 0;
        try{
            n = sc.nextInt();
        }
        catch(Exception e){
            System.out.println("\nEnter valid details!\n");
        }

        switch(n){
            case 1 : menu.manager(sc);
                break;

            case 2 : menu.user(sc);
                break;

            case 3 : sc.close();
                     return;

            default : System.out.println("\n Please enter valid details! \n");
        }
        sc.close();
    }
}
