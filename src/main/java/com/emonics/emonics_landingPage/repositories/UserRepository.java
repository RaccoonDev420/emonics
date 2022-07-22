package com.emonics.emonics_landingPage.repositories;

import com.emonics.emonics_landingPage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
