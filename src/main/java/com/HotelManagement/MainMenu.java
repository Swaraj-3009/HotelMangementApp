package com.HotelManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.HotelManagement.model.User;

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
        UserManagement userManagement = new UserManagement();

        String password;
        int totalRoomToBeBooked = 0;
        int totalPartyHallToBeBooked = 0;
        int totalMeetingHallToBeBooked = 0;

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
                    //Book Room
                case 1 : System.out.println("Enter Password : ");
                         password = sc.nextLine();

                         if(verify.isUserExist(username, password)){
                             User user = verify.userDAO.getUserByNameAndPassword(username, password);
                             System.out.println("Enter total no of room to be booked : ");
                             try{
                                 totalRoomToBeBooked = sc.nextInt();
                                 sc.nextLine();
                             }
                             catch(InputMismatchException e){
                                 e.printStackTrace();
                                 sc.nextLine();
                             }
                                if(verify.isRoomAvailabale(totalRoomToBeBooked)){
                                    userManagement.bookRoom(user, totalRoomToBeBooked);
                                }
                                else{
                                    System.out.println(totalRoomToBeBooked + "Rooms Not Available");
                                }
                             
                             }
                         else{
                             System.out.println("\nIncorrect Password!\n");
                         }
                    break;
                
                case 2 : 
                    break;
                    
                    //Book Party Hall
                case 3 : System.out.println("Enter Password : ");
                         password = sc.nextLine();

                         if(verify.isUserExist(username, password)){
                             User user = verify.userDAO.getUserByNameAndPassword(username, password);
                             System.out.println("Enter total no of Party Hall to be booked : ");
                             try{
                                 totalPartyHallToBeBooked = sc.nextInt();
                                 sc.nextLine();
                             }
                             catch(InputMismatchException e){
                                 e.printStackTrace();
                                 sc.nextLine();
                             }
                                if(verify.isPartyHallAvailable(totalPartyHallToBeBooked)){
                                    userManagement.organiseParty(user, totalPartyHallToBeBooked);
                                }
                                else{
                                    System.out.println(totalPartyHallToBeBooked + "Party Hall Not Available");
                                }
                             }
                         else{
                             System.out.println("\nIncorrect Password!\n");
                         }
                    break;

                case 4 : 
                    break;

                    //Book Meeting Hall
                case 5 : System.out.println("Enter Password : ");
                         password = sc.nextLine();

                         if(verify.isUserExist(username, password)){
                             User user = verify.userDAO.getUserByNameAndPassword(username, password);
                             System.out.println("Enter total no of Meeting Hall to be booked : ");
                             try{
                                 totalMeetingHallToBeBooked = sc.nextInt();
                                 sc.nextLine();
                             }
                             catch(InputMismatchException e){
                                 e.printStackTrace();
                                 sc.nextLine();
                             }
                                if(verify.isMeetingHallAvailable(totalMeetingHallToBeBooked)){
                                    userManagement.bookMeetingHall(user, totalMeetingHallToBeBooked);
                                }
                                else{
                                    System.out.println(totalMeetingHallToBeBooked + "Meeting Hall Not Available");
                                }
                             }
                         else{
                             System.out.println("\nIncorrect Password!\n");
                         }
                    break;

                case 6 : 
                    break;

                case 7 : 
                    break;

                    //Delete User
                case 8 :System.out.print("Enter Passowrd : ");
                        password = sc.nextLine();
                        if(verify.isUserExist(username, password)){
                            bothAccessed.removeUser(username, password);
                            return;
                        }
                        else{
                            System.out.println("Incorrect Password");
                        }
                    break;

                    //Update User Profile
                case 9 : System.out.println("Enter Password : ");
                         password = sc.nextLine();
                         if(verify.isUserExist(username, password)){
                            User user = verify.userDAO.getUserByNameAndPassword(username, password);

                            while(true){
                                System.out.println("1. Change name");
                                System.out.println("2. Change Address");
                                System.out.println("3. Save");
                                System.out.println("4. Exit");

                                try{
                                    n = sc.nextInt();
                                    sc.nextLine();
                                }
                                catch(InputMismatchException e){
                                    e.printStackTrace();
                                    sc.nextLine();
                                }

                                switch(n){
                                    case 1 : System.out.println("New name : ");
                                             user.setName(sc.nextLine());
                                        break;

                                    case 2 : System.out.println("New address : ");
                                             user.setAddress(sc.nextLine());
                                        break;
                                    
                                    case 3 : userManagement.updateUserProfile(user);
                                        break;
                                    
                                    case 4 : return;

                                    default : System.out.println("Enter valid details!");
                                }
                            }
                         }
                         else{
                            System.out.println("Wrong password");
                            break;
                         }
                
                case 10 : return;

                default : 
            }
        }
    }
}