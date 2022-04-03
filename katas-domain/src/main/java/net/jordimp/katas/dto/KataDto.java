package net.jordimp.katas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KataDto {

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
