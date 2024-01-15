package com.kosmos.bootscord.repos;

import com.kosmos.bootscord.entities.BootscordUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BootscordUser, Integer> {
    BootscordUser findByEmail(String email);
    BootscordUser findByUserName(String userName);
}
