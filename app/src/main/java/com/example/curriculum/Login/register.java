package com.example.curriculum.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curriculum.R;
import com.example.curriculum.javabean.User;

public class register extends AppCompatActivity {
    private Button register1;
    private EditText name1,password1;
    private MySQLiteOpenHelper mYsqliteopenhelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mYsqliteopenhelper1 =new MySQLiteOpenHelper(this);
        find();
    }

    private void find()
    {
        register1 = findViewById(R.id.register1);
        name1 = findViewById(R.id.edname);
        password1 = findViewById(R.id.edpassword1);
    }

    public void zhuche(View view)
    {
        String s = name1.getText().toString();
        String s1 = password1.getText().toString();

        User u =new User(s,s1);
        long l = mYsqliteopenhelper1.register(u);
        if (l !=-1)
        {
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            Intent i3 =new Intent(this, MainActivity.class);
            startActivity(i3);
        }
        else
        {
            Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
        }
    }
}