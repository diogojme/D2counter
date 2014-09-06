package com.jd.d2counter.objects;


public class Hero {

    private long id;
    private long type;
    private long image;
    private String name;
    private boolean banned;
    private boolean picked;

    public Hero(long id, String name, long type, long image){
        this.id = id;
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public long getImage() {
        return image;
    }

    public void setImage(long image) {
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

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public static final int TYPE_AGILITY = 1;
    public static final int TYPE_STRENGHT = 2;
    public static final int TYPE_INTELIGENCE = 3;

}
