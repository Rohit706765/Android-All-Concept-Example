package com.example.androidconcept.RoomDataBase.Excersize2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOperation {
    private Context context;
    private MyDataBase dataBase;
    private LiveData<List<Book>> allBook;
    private BookDao bookDao;

    public DataBaseOperation(Context context) {
        this.context = context;
        dataBase = MyDataBase.getInstance(context);
        bookDao = dataBase.bookDao();
        allBook = bookDao.getAllBook();
    }

    public void insert(Book book) {
        new insertModel(bookDao).execute(book);
    }

    public void update(Book book) {
        new UpdateModel(bookDao).execute(book);
    }

    public void delete(Book book) {
        new deleteModel(bookDao).execute(book);
    }

    public void deleteAll(Book book) {
        new deleteAllModel(bookDao).execute();
    }

    public LiveData<List<Book>> getAllBook() {

        return allBook;
    }


    public class insertModel extends AsyncTask<Book, Void, Void> {

        BookDao bookDao;

        public insertModel(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insertBook(books[0]);
            return null;
        }
    }

    public class UpdateModel extends AsyncTask<Book, Void, Void> {

        BookDao bookDao;

        public UpdateModel(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.updateBook(books[0]);
            return null;
        }
    }

    public class deleteModel extends AsyncTask<Book, Void, Void> {

        BookDao bookDao;

        public deleteModel(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.deleteBook(books[0]);
            return null;
        }
    }

    public class deleteAllModel extends AsyncTask<Void, Void, Void> {

        BookDao bookDao;

        public deleteAllModel(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAll();
            return null;
        }
    }
}
