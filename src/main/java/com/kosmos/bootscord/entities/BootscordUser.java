package com.kosmos.bootscord.entities;

import com.kosmos.bootscord.enums.DisplayStatus;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.Arrays;

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
//    @Column
//    private byte[] profilePicture;
    @Column
    private String email;
//    @Column
//    private DisplayStatus status;
    @Column
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

//    public byte[] getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(byte[] profilePicture) {
//        this.profilePicture = profilePicture;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public DisplayStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(DisplayStatus status) {
//        this.status = status;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BootscordUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
//                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", email='" + email + '\'' +
//                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}