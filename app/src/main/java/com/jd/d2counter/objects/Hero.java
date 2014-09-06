package com.jd.d2counter.objects;


import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {

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


    private Hero(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.type = parcel.readLong();
        this.image = parcel.readLong();
    }


    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeLong(type);
        parcel.writeLong(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {

        @Override
        public Hero createFromParcel(Parcel parcel) {
            return new Hero(parcel);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public static final int TYPE_AGILITY = 1;
    public static final int TYPE_STRENGHT = 2;
    public static final int TYPE_INTELIGENCE = 3;

}
