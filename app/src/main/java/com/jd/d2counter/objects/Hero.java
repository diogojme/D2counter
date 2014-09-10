package com.jd.d2counter.objects;


import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {

    private long id;
    private long type;
    private long image;
    private String name;
    private int status;


    public Hero(long id, String name, long type, long image, int status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.image = image;
        this.status = status;
    }

    public long getImage() {
        return image;
    }


    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public long getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    private Hero(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.type = parcel.readLong();
        this.image = parcel.readLong();
        this.status = parcel.readInt();
    }


    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeLong(type);
        parcel.writeLong(image);
        parcel.writeInt(status);
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

    public static final int STATUS_NOTHING = 0;
    public static final int STATUS_MY_PICK = 1;
    public static final int STATUS_ENEMY_PICK = 2;
    public static final int STATUS_MY_BAN = 3;
    public static final int STATUS_ENEMY_BAN= 4;
    public static final int STATUS_SUGGESTION_PICK = 5;
    public static final int STATUS_SUGGESTION_BAN= 6;

    public static final String EXTRA_STATUS_NAME = "status";
}
