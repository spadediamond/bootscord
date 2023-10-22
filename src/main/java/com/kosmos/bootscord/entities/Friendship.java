package com.kosmos.bootscord.entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Friendship {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private BootscordUser userOne;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private BootscordUser userTwo;

    @Column
    private boolean accepted;
}
