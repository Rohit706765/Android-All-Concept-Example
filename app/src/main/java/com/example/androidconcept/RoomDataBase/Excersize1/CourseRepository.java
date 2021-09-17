package com.example.androidconcept.RoomDataBase.Excersize1;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;


public class CourseRepository {
	
	// below line is the create a variable
	// for UserDao and list for all courses.
	private UserDao UserDao;
	private LiveData<List<User>> allCourses;

	// creating a constructor for our variables
	// and passing the variables to it.
	public CourseRepository(Context application) {
		AppDataBase database = AppDataBase.getInstance(application);
		UserDao = database.userDao();
		allCourses = UserDao.getAlluser();
	}

	// creating a method to insert the data to our database.
	public void insert(User model) {
		new InsertCourseAsyncTask(UserDao).execute(model);
	}

	// creating a method to update data in database.
	public void update(User model) {
		new UpdateCourseAsyncTask(UserDao).execute(model);
	}

	// creating a method to delete the data in our database.
	public void delete(User model) {
		new DeleteCourseAsyncTask(UserDao).execute(model);
	}

	// below is the method to delete all the courses.
	public void deleteAllCourses() {
		new DeleteAllCoursesAsyncTask(UserDao).execute();
	}

	// below method is to read all the courses.
	public LiveData<List<User>> getAllCourses() {
		return allCourses;
	}

	// we are creating a async task method to insert new course.
	private static class InsertCourseAsyncTask extends AsyncTask<User, Void, Void> {
		private UserDao UserDao;

		private InsertCourseAsyncTask(UserDao UserDao) {
			this.UserDao = UserDao;
		}

		@Override
		protected Void doInBackground(User... model) {
			// below line is use to insert our modal in UserDao.
			UserDao.insert(model[0]);
			return null;
		}
	}

	// we are creating a async task method to update our course.
	private static class UpdateCourseAsyncTask extends AsyncTask<User, Void, Void> {
		private UserDao UserDao;

		private UpdateCourseAsyncTask(UserDao UserDao) {
			this.UserDao = UserDao;
		}

		@Override
		protected Void doInBackground(User... models) {
			// below line is use to update
			// our modal in UserDao.
			UserDao.update(models[0]);
			return null;
		}
	}

	// we are creating a async task method to delete course.
	private static class DeleteCourseAsyncTask extends AsyncTask<User, Void, Void> {
		private UserDao UserDao;

		private DeleteCourseAsyncTask(UserDao UserDao) {
			this.UserDao = UserDao;
		}

		@Override
		protected Void doInBackground(User... models) {
			// below line is use to delete
			// our course modal in UserDao.
			UserDao.delete(models[0]);
			return null;
		}
	}

	// we are creating a async task method to delete all courses.
	private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
		private UserDao UserDao;
		private DeleteAllCoursesAsyncTask(UserDao UserDao) {
			this.UserDao = UserDao;
		}
		@Override
		protected Void doInBackground(Void... voids) {
			// on below line calling method
			// to delete all courses.
			UserDao.deleteAll();
			return null;
		}
	}
}
