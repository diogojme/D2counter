package com.jd.d2counter.objects;


public class Hero {

    private long id;
    private long type;
    private int image;
    private String name;

    public Hero(long id, String name, long type, int image){
        this.id = id;
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public static final int TYPE_AGILITY = 1;
    public static final int TYPE_STRENGHT = 2;
    public static final int TYPE_INTELIGENCE = 3;

}
