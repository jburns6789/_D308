package com.project.d_308_final.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.project.d_308_final.entities.Vacation;

import java.util.List;

@Dao
public interface VacationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Vacation vacation);

    @Update
    void update(Vacation vacation);

    @Delete
    void delete(Vacation vacation);

    @Query("SELECT * FROM VACATIONS ORDER BY VACATIONID ASC" )
    List<Vacation> getAllVacations();

    @Query("SELECT * FROM VACATIONS WHERE VACATIONID = VACATIONID ORDER BY VACATIONID ASC")
    List<Vacation> getAllVacationsById();

}