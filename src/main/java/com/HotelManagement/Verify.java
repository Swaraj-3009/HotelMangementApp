package com.HotelManagement;

import com.HotelManagement.model.Manager;
import com.HotelManagement.model.User;

class Verify {
    Manager manage = new Manager();
    User user = new User();
    
    int verifyManager(String username, String password){
        if(username.equalsIgnoreCase(manage.getUsername()) && password.equalsIgnoreCase(manage.getPassword())){
            return 1;
        }
        return 0;
    }

    int isUserExist(String username, String password){
        if(username.equalsIgnoreCase(user.getName())){
            return 1;
        }
        return 0;
    }
}
