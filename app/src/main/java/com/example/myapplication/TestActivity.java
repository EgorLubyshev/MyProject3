package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    ArrayList<Task> tasks = new ArrayList<>();
    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.c1);//, textView2, textView3, textView4

        TasksLoader tasksLoader = new TasksLoader();
        tasksLoader.setOnPostExecute(new TasksLoader.OnPostExecute() {
            @Override
            public void doOnPostExecute(TaskAnswer answer) {
                tasks = answer.data;
                
                setTask(tasks.get(0));
            }
        });

        tasksLoader.execute("http://10.148.190.161");
    }

    void setTask(Task task){
        textView1.setText(task.variants.get(0));
    }
}
