package com.example.android_layouts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RadioGroup rg;
        RadioButton r1, r2, r3, r4, r5;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = findViewById(R.id.rg);
        r1 = findViewById(R.id.rb_Constraint);
        r2 = findViewById(R.id.rb_Horizontal);
        r3 = findViewById(R.id.rb_Vertical);
        r4 = findViewById(R.id.rb_Frame);
        r5 = findViewById(R.id.rb_Table);

        rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (r1.isChecked())
                startActivity(new Intent(MainActivity.this, constraint_activity.class));
            if (r2.isChecked())
                startActivity(new Intent(MainActivity.this, horizontal_activity.class));
            if (r3.isChecked())
                startActivity(new Intent(MainActivity.this, vertical_activity.class));
            if (r4.isChecked())
                startActivity(new Intent(MainActivity.this, frame_activity.class));
            if (r5.isChecked())
                startActivity(new Intent(MainActivity.this, table_activity.class));
        });
    }
}
