package com.project.d_308_final.Database;

import android.app.Application;

import com.project.d_308_final.dao.ExcursionDao;
import com.project.d_308_final.dao.VacationDao;
import com.project.d_308_final.entities.Excursion;
import com.project.d_308_final.entities.Vacation;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private VacationDao mVacationDAO;
    private ExcursionDao mExcursionDAO;
    private List<Excursion> mAllExcursions;
    private List<Vacation> mAllVacations;
    private List<Vacation>mAllVacationsById;
    private static int NUMBER_OF_THREADS = 4; //multithreading
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    //executor services needed to create threads

    //Live data requires another handshake and using the observer class

    public Repository(Application application) {
        TravelDatabaseBuilder db = TravelDatabaseBuilder.getDatabase(application);
        mVacationDAO = db.VacationDao();
        mExcursionDAO = db.ExcursionDao();
    }

    //First insert is necessary to jump start the entire process
    //this is being performed on a separate thread
    //Thread.sleep is necessary to give the thread time to perform the action
    //in java an interruptedException is necessary
    public List<Vacation> getAllVacations() {
        databaseExecutor.execute(() -> {
            mAllVacations = mVacationDAO.getAllVacations();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllVacations;
    }

    public List<Vacation> getAllVacationsById() {
        databaseExecutor.execute(() -> {
            mAllVacationsById = mVacationDAO.getAllVacationsById();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllVacationsById;
    }



    public void insert(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.insert(vacation);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.update(vacation);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.delete(vacation);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Excursion> getAllExcursions() {
        databaseExecutor.execute(() -> {
            mAllExcursions = mExcursionDAO.getAllExcursions();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExcursions;
    }

    public void insert(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.insert(excursion);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.update(excursion);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.delete(excursion);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
