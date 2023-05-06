package com.example.curriculum.CourseManage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curriculum.R;
import com.example.curriculum.javabean.Success;

public class create extends AppCompatActivity {
    private Button create1;

    private EditText successid1,successname1,classroom1,teacher1,time1;

    private SuccessSQLiteOpenHelper successSQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        successSQLiteOpenHelper = new SuccessSQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        create1 = findViewById(R.id.create1);

        successid1 = findViewById(R.id.successid1);
        successname1 = findViewById(R.id.successname1);
        classroom1 = findViewById(R.id.classroom1);
        teacher1 = findViewById(R.id.teacher1);
        time1 = findViewById(R.id.time1);
    }

    public void charu(View view)
    {
        String s1 = successid1.getText().toString();
        String s2 = successname1.getText().toString();
        String s3 = classroom1.getText().toString();
        String s4 = teacher1.getText().toString();
        String s5 = time1.getText().toString();

        Success s = new Success(s1,s2,s3,s4,s5);
        long l = successSQLiteOpenHelper.create(s);
        if(l != -1)
        {
            Toast.makeText(this, "插入成功！", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this, success.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish(); // 销毁当前Activity
        }
        else
        {
            Toast.makeText(this, "插入失败！", Toast.LENGTH_SHORT).show();
        }
    }
}