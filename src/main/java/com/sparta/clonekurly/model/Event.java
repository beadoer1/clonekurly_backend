package com.sparta.clonekurly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String subtitle;

    @Column(name = "img_url")
    private String img;

}
