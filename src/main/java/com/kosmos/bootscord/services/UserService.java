package com.kosmos.bootscord.services;

import com.kosmos.bootscord.entities.BootscordUser;

public interface UserService {
    // Creates a new user in the database
    BootscordUser registerUser(BootscordUser user);
}
