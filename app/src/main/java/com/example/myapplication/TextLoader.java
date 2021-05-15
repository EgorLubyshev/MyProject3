package com.example.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

class TextLoader extends AsyncTask<String, Integer, Answer> {
    TextView textView;
     int id;

     TextLoader(TextView textView, int id){
         this.textView=textView;
         this.id=id;
     }

    @Override
    protected Answer doInBackground(String... strings) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(strings[0])
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserServers userServers = retrofit.create(UserServers.class);

        Call<Answer> call = userServers.getUsers(id);

        try {
            Response<Answer> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Answer answer) {
        if (answer != null) {
            textView.setText(answer.getUsers());
        } else {
            textView.setText("Ошибка");
        }


    }


    interface UserServers {

        @GET("get_user.php")
        Call<Answer> getUsers(
                @Query("id") int id
        );

        @GET("set_user.php")
        Call<Answer> setUsers(
                @Query("login") String login,
                @Query("password") String pass,
                @Query("mail") String mail
        );
    }


}

class Answer {
    boolean status;
    ArrayList<User> data;

    String getUsers() {
        String res = "";
        for (User user : data) {
            res += user.toString() + "\n";

        }
        return res;
    }
}

class User {
    int id;
    String login, password, mail;

    @NonNull
    @Override
    public String toString() {
        return id + ", " + login + ", " + password + ", " + mail;
    }
}

