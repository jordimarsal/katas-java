package net.jordimp.katas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Document
public class KataEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private String url;
    private String language;
    private String category;
    private String level;
    private String author;
    private String date;
    private String time;
    private String votes;
    private String comments;
    private String views;
    private String stars;

}
