package com.example.curriculum.CourseManage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.curriculum.R;
import com.example.curriculum.javabean.Success;

public class delete extends AppCompatActivity {
    private Button delete1;

    private EditText successid3;

    private TextView successname3,classroom3,teacher3,time3;

    private SuccessSQLiteOpenHelper successSQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        successSQLiteOpenHelper = new SuccessSQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        delete1 = findViewById(R.id.delete1);

        successid3 = findViewById(R.id.successid3);
        successname3 = findViewById(R.id.successname3);
        classroom3 = findViewById(R.id.classroom3);
        teacher3 = findViewById(R.id.teacher3);
        time3 = findViewById(R.id.time3);
    }

    int count = 0;

    public void shanchu(View v)
    {
        count++;
        if(count == 1)
        {
            String Sid = successid3.getText().toString();
            Success suc = successSQLiteOpenHelper.read(Sid);
            successname3.setText(suc.getSuccessname());
            classroom3.setText(suc.getClassroom());
            teacher3.setText(suc.getTeacher());
            time3.setText(suc.getTime());
            Toast.makeText(this, "展示要删除的数据，再按一次删除数据！", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String Sid = successid3.getText().toString();
            boolean l = successSQLiteOpenHelper.delete(Sid);
            if(l)
            {
                Toast.makeText(this, "删除成功！", Toast.LENGTH_SHORT).show();
                Intent i =new Intent(this, success.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish(); // 销毁当前Activity
            }
            else
            {
                Toast.makeText(this, "删除失败！", Toast.LENGTH_SHORT).show();
            }
        }

    }
}