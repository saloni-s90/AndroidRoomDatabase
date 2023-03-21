package com.example.displayrecords;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AllDao {
    @Insert
    long insertUser(UserModel userModel);

    @Insert
    void  insertEmploy(InfoModel infoModel);

    @Query("SELECT * FROM usermodel")
    List<UserModel> getAllUsers();

    @Query("SELECT * FROM InfoModel where userid=:id")
    List<InfoModel> getMyEmployName(int id);


}
