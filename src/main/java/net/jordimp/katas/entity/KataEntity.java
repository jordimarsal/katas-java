package net.jordimp.katas.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class KataEntity {

    private String name;
    private String description;
    private String url;
    private String language;
    private String category;
    private String level;
    private String author;
    private String id;
    private String date;
    private String time;
    private String votes;
    private String comments;
    private String views;
    private String stars;

}
