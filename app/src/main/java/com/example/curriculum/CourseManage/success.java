package com.example.curriculum.CourseManage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.curriculum.R;

public class success extends AppCompatActivity implements View.OnClickListener {
    private Button create,delete,update,read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        find();
    }

    private void find()
    {
        create = findViewById(R.id.create);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        read = findViewById(R.id.read);

        create.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.create)
        {
            Intent cre = new Intent(this, com.example.curriculum.CourseManage.create.class);
            startActivity(cre);
        }
        if(id == R.id.delete)
        {
            Intent reg = new Intent(this, com.example.curriculum.CourseManage.delete.class);
            startActivity(reg);
        }
        if(id == R.id.update)
        {
            Intent upd = new Intent(this, com.example.curriculum.CourseManage.update.class);
            startActivity(upd);
        }
        if(id == R.id.read)
        {
            Intent red = new Intent(this, com.example.curriculum.CourseManage.read.class);
            startActivity(red);
        }
    }
}