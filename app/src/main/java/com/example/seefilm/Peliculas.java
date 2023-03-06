package com.example.seefilm;

public class Peliculas {
    private String name,trailer,description;
    private int imgurl;

    public Peliculas(String name, String trailer, int imgurl, String description) {
        this.name = name;
        this.trailer = trailer;
        this.imgurl = imgurl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgurl() {
        return imgurl;
    }

    public void setImgurl(int imgurl) {
        this.imgurl = imgurl;
    }
}
