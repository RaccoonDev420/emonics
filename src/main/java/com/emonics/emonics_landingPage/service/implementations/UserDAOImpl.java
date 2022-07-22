package com.emonics.emonics_landingPage.service.implementations;

import com.emonics.emonics_landingPage.entities.User;
import com.emonics.emonics_landingPage.repositories.UserRepository;
import com.emonics.emonics_landingPage.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl extends GenericDAOImpl<User, UserRepository> implements UserDAO {

    @Autowired
    public UserDAOImpl(UserRepository repository) {
        super(repository);
    }
}
