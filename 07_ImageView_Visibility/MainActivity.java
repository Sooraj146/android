package com.example.imageview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    Button buttonToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        buttonToggle = findViewById(R.id.buttonToggle);

        buttonToggle.setOnClickListener(v -> {
            if (imageView1.getVisibility() == View.VISIBLE) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
            } else {
                imageView1.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
            }
        });
    }
}