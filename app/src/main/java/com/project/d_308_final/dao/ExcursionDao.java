package com.project.d_308_final.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.project.d_308_final.entities.Excursion;

import java.util.List;


@Dao
public interface ExcursionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Excursion excursion);

    @Update
    void update(Excursion excursion);

    @Delete
    void delete(Excursion excursion);

    @Query("SELECT* FROM EXCURSIONS ORDER BY EXCURSIONTITLE ASC")
    List<Excursion> getAllExcursions();
/*
    @Query("SELECT * FROM EXCURSIONS WHERE VACATIONID = VACATIONID ORDER BY vacationId ASC ")
    List<Excursion> getAllExcursionsById(int vacationId);

 */
}
