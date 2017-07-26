package com.fx.spring.Dao;

import com.fx.spring.Entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 25/07/2017.
 */
public interface UserDAO {
    public List<User> getListOfAllUsers();
}
