package com.kosmos.bootscord.entities;

import com.kosmos.bootscord.enums.DisplayStatus;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class BootscordUser {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column
    private String userName;
    @Column
    private String displayName;
    @Column
    private byte[] profilePicture;
    @Column
    private String email;
    @Column
    private DisplayStatus status;
    @Column
    private String password;



}