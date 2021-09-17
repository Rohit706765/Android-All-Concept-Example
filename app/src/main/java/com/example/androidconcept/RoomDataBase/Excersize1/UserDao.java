package com.example.androidconcept.RoomDataBase.Excersize1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userId)")
    List<User> getAllById(int[] userId);

    @Query("SELECT * FROM user WHERE userName IN (:first) AND lastName IN (:last) LIMIT 1")
    List<User> findByName(String first, String last);

    @Update
    void update(User user);

    @Insert
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("DELETE  FROM user")
    void deleteAll();

    @Query("SELECT * FROM user ORDER BY userName ASC")
    LiveData<List<User>> getAlluser();
}
