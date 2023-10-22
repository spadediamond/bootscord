package com.kosmos.bootscord.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private BootscordUser sender;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private BootscordUser receiver;

    @Column
    private LocalDateTime dateSent;

    @Column
    private String content;
}
