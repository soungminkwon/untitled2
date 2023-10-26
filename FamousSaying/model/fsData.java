package _23_10_24.FamousSaying.model;

import java.io.Serializable;

public class fsData implements Serializable{
    Long id;
    String fas;
    String author;

    public fsData() {
    }

    public fsData(Long id, String fas, String author) {
        this.id = id;
        this.fas = fas;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFas() {
        return fas;
    }

    public void setFas(String fas) {
        this.fas = fas;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
