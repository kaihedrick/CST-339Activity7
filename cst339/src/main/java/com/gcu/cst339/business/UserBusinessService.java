package com.gcu.cst339.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.cst339.data.entity.UserEntity;
import com.gcu.cst339.data.repository.UsersRepository;
import com.gcu.cst339.model.UserModel;

@Service
public class UserBusinessService {
    @Autowired
    private com.gcu.cst339.data.repository.UsersRepository usersRepository;
    /**
     * Non-Default constructor for constructor injection 
     * */
    public UserBusinessService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }
    /**
     * Get all Users from the databasee
     */
    public List<UserModel> getAllUsers()
    {
        //get all the entity users
        List<UserEntity> usersEntity = usersRepository.findAll();
        //iterate over the entity users and create a list of domain users
        List<UserModel> usersDomain = new ArrayList<UserModel>();
        for(UserEntity user : usersEntity)
        {
            usersDomain.add(new UserModel(user.getId(), user.getUsername(), user.getPassword()));
        }
        //return the list
        return usersDomain;
    }
}
