package com.example.android.finalandroid511;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;


import butterknife.BindView;
import butterknife.ButterKnife;
public class MenuActivity extends AppCompatActivity {
    Context context;
    @BindView(R.id.imageButton_employee)
    ImageButton employeeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context=this.getApplicationContext();
        ButterKnife.bind(this);
        employeeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityTo(EmployeeActivity.class);
            }
        });
    }

    private void startActivityTo(Class<EmployeeActivity> employeeActivityClass) {
        Intent intent = new Intent(context,employeeActivityClass);
        startActivity(intent);
    }
}
