package com.HotelManagement;

import java.util.*;

import com.Schedulor.BookingExpirationSchedulor;

//login as Manager or User
public class App {
    public static void main( String[] args ){
        BookingExpirationSchedulor schedulor = new BookingExpirationSchedulor();
        schedulor.start();

        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        Verify verify = new Verify();

        String u,p;

        while(true){
            System.out.println("Book My Hotel");

            System.out.println("1. Login as Manager");
            System.out.println("2. Login as User");
            System.out.println("3. Exit");

            int n = 0;
            try{
                n = sc.nextInt();
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("\nEnter valid details!\n");
                sc.nextLine();
                continue;
            }

            switch(n){
                case 1 :System.out.print("Enter username : ");
                        u = sc.nextLine();
                        System.out.print("Enter Password : ");
                        p = sc.nextLine();

                        if(verify.verifyManager(u, p)){
                            menu.manager(sc, verify);
                        }
                        else{
                            System.out.println("\nWRONG USERNAME OR PASSWORD!\n");
                        }
                    break;

                case 2 : System.out.println("1. Already have account");
                         System.out.println("2. New user");

                         try{
                            int a = sc.nextInt();
                            sc.nextLine();

                            switch(a){
                                case 1 : System.out.print("Enter name : ");
                                         u = sc.nextLine();
                                         System.out.print("Enter Password : ");
                                         p = sc.nextLine();
                                         
                                         if(verify.isUserExist(u , p)){
                                            menu.user(sc, verify, u);
                                         }
                                         else{
                                            System.out.println("\nUser not Exist\n");
                                         }
                                    break;

                                case 2 : System.out.print("Enter name : ");
                                         u = sc.nextLine();
                                         System.out.print("Enter Passowrd : ");
                                         p = sc.nextLine();

                                         menu.bothAccessed.addUser(u,p,sc);
                                         menu.user(sc, verify, u);
                                    break;

                                default : System.out.println("\nPlease Enter Valid Details!\n");
                            }
                         }
                         catch(InputMismatchException e){
                            System.out.println("\nEnter Valid Details!\n");
                            sc.nextLine();
                         }
                         
                    break;

                case 3 : sc.close();
                        return;

                default : System.out.println("\n Please enter valid details! \n");
            }
        }
    }

}
