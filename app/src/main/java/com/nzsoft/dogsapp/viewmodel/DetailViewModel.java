package com.nzsoft.dogsapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nzsoft.dogsapp.model.DogBreed;
import com.nzsoft.dogsapp.model.DogDatabase;

public class DetailViewModel extends AndroidViewModel {

    public MutableLiveData <DogBreed> dogLiveData = new MutableLiveData<>();

    private AsyncTask<Integer, Void, DogBreed> retrieveDogTask;

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetch (Integer uuid) {
        retrieveDogTask = new RetrieveDogTask();
        retrieveDogTask.execute(uuid);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        if (retrieveDogTask != null) {
            retrieveDogTask.cancel(true);
            retrieveDogTask = null;
        }
    }

    private class RetrieveDogTask extends AsyncTask <Integer, Void, DogBreed> {

        @Override
        protected DogBreed doInBackground(Integer... integers) {
            int uuid = integers[0];
            return DogDatabase.getInstance(getApplication()).dogDao().getDog(uuid);
        }

        @Override
        protected void onPostExecute(DogBreed dogBreed) {
            dogLiveData.setValue(dogBreed);
        }
    }
}
