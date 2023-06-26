package com.project.d_308_final.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.d_308_final.dao.ExcursionDao;
import com.project.d_308_final.dao.VacationDao;
import com.project.d_308_final.entities.Excursion;
import com.project.d_308_final.entities.Vacation;

@Database(entities = {Vacation.class, Excursion.class}, version=2, exportSchema = false)
public abstract class TravelDatabaseBuilder extends RoomDatabase {
    public abstract VacationDao VacationDao();
    public abstract ExcursionDao ExcursionDao();
    //need a instance of the database
    private static volatile TravelDatabaseBuilder INSTANCE;

    static TravelDatabaseBuilder getDatabase(final Context context){
        if(INSTANCE==null) { //check to see if it exists, if exists old one is updated
            synchronized (TravelDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TravelDatabaseBuilder.class, "MyTravelDatabase.db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }

            }

        }
        return INSTANCE;
    }
}
