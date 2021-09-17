package com.example.androidconcept.RoomDataBase.Excersize2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BookList")
public class Book {
    @PrimaryKey
    public int bid;
    @ColumnInfo(name = "BookName")
    public String name;
    @ColumnInfo(name = "BookPrice")
    public String bPrice;

    public Book(String name, String bPrice) {
        this.name = name;
        this.bPrice = bPrice;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbPrice() {
        return bPrice;
    }

    public void setbPrice(String bPrice) {
        this.bPrice = bPrice;
    }
}
