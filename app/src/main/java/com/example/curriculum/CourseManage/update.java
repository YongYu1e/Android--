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

public class update extends AppCompatActivity {
    private Button updata1;

    private EditText successid4,successname4,classroom4,teacher4,time4;

    private SuccessSQLiteOpenHelper successSQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        successSQLiteOpenHelper = new SuccessSQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        updata1 = findViewById(R.id.updata1);

        successid4 = findViewById(R.id.successid4);
        successname4 = findViewById(R.id.successname4);
        classroom4 = findViewById(R.id.classroom4);
        teacher4 = findViewById(R.id.teacher4);
        time4 = findViewById(R.id.time4);
    }

    public void xiugai(View v)
    {
        String Sid = successid4.getText().toString();
        Success s = successSQLiteOpenHelper.read(Sid);
        String Sna = successname4.getText().toString();
        String Cla = classroom4.getText().toString();
        String Tea = teacher4.getText().toString();
        String Time = time4.getText().toString();

        Success suc = new Success(Sid,Sna,Cla,Tea,Time);
        boolean l = successSQLiteOpenHelper.update(suc);
        if(l)
        {
            Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this, success.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish(); // 销毁当前Activity
        }
        else
        {
            Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();
        }
    }
}