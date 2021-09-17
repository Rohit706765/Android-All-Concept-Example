package com.example.androidconcept.RoomDataBase.Excersize2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidconcept.RoomDataBase.Excersize1.User;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM BookList")
    public LiveData<List<Book>> getAllBook();

    @Query("SELECT * FROM BookList WHERE bid IN(:bid)")
    public List<Book> getAllBookById(int bid);

    @Insert
    public void insertBook(Book book);
    @Update
    public void updateBook(Book book);
    @Delete
    public void deleteBook(Book book);

    @Query("SELECT * FROM BookList WHERE BookName IN(:BookName)")
    public List<Book> getAllBookByName(String BookName);

    @Query("SELECT * FROM BookList WHERE BookPrice IN(:BookPrice)")
    public List<Book> getAllBookByPrice(String BookPrice);

    @Query("DELETE FROM BookList")
    public void deleteAll();
}
