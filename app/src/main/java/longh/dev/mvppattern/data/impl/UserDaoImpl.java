package longh.dev.mvppattern.data.impl;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import longh.dev.mvppattern.data.dao.UserDao;
import longh.dev.mvppattern.data.driver.SQLiteDb;
import longh.dev.mvppattern.data.model.User;

public class UserDaoImpl implements UserDao {
    final String DATABASE_NAME = "mvpp.db";
    SQLiteDatabase sqLiteDatabase;
    Context context;

    public UserDaoImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean insert(User user) {
        sqLiteDatabase = SQLiteDb.initDatabase((Activity) context, DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Accout",null);
        for(int i = 0 ; i < cursor.getCount(); i++ ){
            cursor.moveToPosition(i);
            if(!user.getEmail().equals(cursor.getString(1))){
                ContentValues contentValues = new ContentValues();
                contentValues.put("user", user.getEmail());
                contentValues.put("password", user.getPassword());
                sqLiteDatabase.insert("Accout", null, contentValues);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        sqLiteDatabase = SQLiteDb.initDatabase((Activity) context, DATABASE_NAME);
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",user.getPassword());
        sqLiteDatabase.update("Accout", contentValues, "user =?", new String[]{user.getEmail()});
        return false;
    }

    @Override
    public boolean delete(int id) {
        sqLiteDatabase = SQLiteDb.initDatabase((Activity) context, DATABASE_NAME);
        sqLiteDatabase.delete("Accout", "id= ?", new String[]{id+""});

        return true;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public User find(String email, String password) {
        sqLiteDatabase = SQLiteDb.initDatabase((Activity) context,DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Accout",null);
        for(int i =0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            if(email.equals(cursor.getString(1)) && password.equals(cursor.getString(2))){
                return new User(cursor.getString(1), cursor.getString(2));
            }
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        sqLiteDatabase = SQLiteDb.initDatabase((Activity) context,DATABASE_NAME);
        List<User> lstUsers = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Accout",null);
        for(int i =0; i< cursor.getCount();i++){
            cursor.moveToPosition(i);
            lstUsers.add(new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        return lstUsers;
    }
}
