package com.HotelManagement;

import java.util.Scanner;

class MainMenu {
    BothAccessed bothAccessed = new BothAccessed();

    public void manager(Scanner sc, Verify verify){
        ManagerManagement managerManagement = new ManagerManagement();

        String userUsername, userPassword;

        while(true){
            System.out.println("\nMain Menu\n");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Add User");
            System.out.println("4. Remove User");
            System.out.println("5. Check booked Room");
            System.out.println("6. Check Unbooked Room");
            System.out.println("7. Total Employee");
            System.out.println("8. Search User By Adhaar");
            System.out.println("9. Total User");
            System.out.println("10. Exit");

            int n = 0;
            try{
                n = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e){
                System.out.println("\nEnter valid details!\n");
                sc.nextLine();
                continue;
            }

            switch(n){
                case 1 : 
                    break;
                
                case 2 : 
                    break;

                    //add user
                case 3 :System.out.print("Enter name : ");
                        userUsername = sc.nextLine();
                        System.out.print("Enter Passowrd : ");
                        userPassword = sc.nextLine();
                        if(verify.isUserExist(userUsername, userPassword)){
                            System.out.println("User Already Exist");
                        }
                        else{
                            bothAccessed.addUser(userUsername, userPassword, sc);
                        }
                    break;

                    //remove user
                case 4 :System.out.print("Enter name : ");
                        userUsername = sc.nextLine();
                        System.out.print("Enter Passowrd : ");
                        userPassword = sc.nextLine();
                        if(verify.isUserExist(userUsername, userPassword)){
                            bothAccessed.removeUser(userUsername, userPassword);
                        }
                        else{
                            System.out.println("User does not exist");
                        }
                    break;

                case 5 : 
                    break;

                case 6 : 
                    break;

                case 7 : 
                    break;

                    //get user by adhaar
                case 8 : System.out.println("Enter Adhaar : ");
                         String adhaar = sc.nextLine();

                         if(verify.isUserExistByAdhaar(adhaar)){
                            managerManagement.getUserByAdhaar(adhaar);
                        }
                        else{
                            System.out.println("User does not exist");
                        }
                    break;

                    //total user
                case 9 : managerManagement.totalUser();
                    break;

                case 10 : return;

                default : 
            }
        }
    }

    public void user(Scanner sc, Verify verify, String username){
        //UserManagement userManagement = new UserManagement();

        while(true){
            System.out.println("\nMain Menu\n");
            System.out.println("1. Book room ");
            System.out.println("2. Order food ");
            System.out.println("3. Organise party");
            System.out.println("4. Take swimming pass");
            System.out.println("5. Book meeting hall");
            System.out.println("6. Take playzone pass");
            System.out.println("7. Take gym pass");
            System.out.println("8. Delete Account");
            System.out.println("9. Update Profile");
            System.out.println("10. Exit");

            int n = 0;
            try{
                n = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e){
                System.out.println("\nEnter valid details!\n");
                sc.nextLine();
                continue;
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

                case 8 :System.out.print("Enter Passowrd : ");
                        String password = sc.nextLine();
                        if(verify.isUserExist(username, password)){
                            bothAccessed.removeUser(username, password);
                            return;
                        }
                        else{
                            System.out.println("Incorrect Password");
                        }
                    break;

                case 9 : 
                    break;
                
                case 10 : return;

                default : 
            }
        }
    }
}