package com.example.javazoos.models;

import javax.persistence.*;

@Entity
@Table(name = "zoos")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false,
            unique = true)
    private String zooname;

    public Zoo() {
    }

    public Zoo(String zooname) {
        this.zooname = zooname;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }
}
