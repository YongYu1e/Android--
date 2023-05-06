package com.example.curriculum.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curriculum.CourseManage.success;
import com.example.curriculum.Login.MySQLiteOpenHelper;
import com.example.curriculum.R;

public class MainActivity extends AppCompatActivity {
private Button login,register;
private EditText name,password;
private MySQLiteOpenHelper mySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        name = findViewById(R.id.edname);
        password = findViewById(R.id.edpassword);
    }

    public void login(View view)
    {
        String s = name.getText().toString();
        String s1 = password.getText().toString();

        boolean login = mySQLiteOpenHelper.login(s,s1);
        if(login)
        {
            Toast.makeText(this,"登录成功!",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, success.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish(); // 销毁当前Activity
        }
        else
        {
            Toast.makeText(this,"登录失败!",Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view)
    {
        Intent i = new Intent(this, com.example.curriculum.Login.register.class);
        startActivity(i);
    }
}