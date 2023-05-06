package com.example.curriculum.CourseManage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.curriculum.R;
import com.example.curriculum.javabean.Success;

public class read extends AppCompatActivity {
    private Button read1;

    private EditText successid2;

    private TextView successname2,classroom2,teacher2,time2;

    private SuccessSQLiteOpenHelper successSQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        successSQLiteOpenHelper = new SuccessSQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        read1 = findViewById(R.id.read1);

        successid2 = findViewById(R.id.successid2);
        successname2 = findViewById(R.id.successname2);
        classroom2 = findViewById(R.id.classroom2);
        teacher2 = findViewById(R.id.teacher2);
        time2 = findViewById(R.id.time2);
    }

    public void chaxun(View v)
    {
        String Sid = successid2.getText().toString();
        Success suc = successSQLiteOpenHelper.read(Sid);
        successname2.setText(suc.getSuccessname());
        classroom2.setText(suc.getClassroom());
        teacher2.setText(suc.getTeacher());
        time2.setText(suc.getTime());
    }
}