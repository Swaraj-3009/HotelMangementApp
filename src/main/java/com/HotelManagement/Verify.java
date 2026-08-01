package com.HotelManagement;

import com.HotelManagement.model.Manager;

class Verify {
    Manager manage = new Manager();
    int verifyManager(String username, String password){
        if(username.equalsIgnoreCase(manage.getUsername()) && password.equalsIgnoreCase(manage.getPassword())){
            return 1;
        }
        return 0;
    }

    int isUserExist(String username, String password){
        return 0;
    }
}
