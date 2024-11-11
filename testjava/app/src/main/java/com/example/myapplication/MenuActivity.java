package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize views
        TextView btnDone = findViewById(R.id.btnDone);
        TextView btnPtoToil = findViewById(R.id.btnPtoToil);
        TextView btnNotifications = findViewById(R.id.btnNotifications);
        TextView btnPreferences = findViewById(R.id.btnPreferences);
        TextView btnLogout = findViewById(R.id.btnLogout);
        TextView txtUserName = findViewById(R.id.txtUserName);
        ImageView profileImage = findViewById(R.id.profileImage);

        // Set click listeners
        btnDone.setOnClickListener(v -> finish());

        btnPtoToil.setOnClickListener(v -> {
            Toast.makeText(this, "PTO & TOIL clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MenuActivity.this, BookActivity.class));
            finish();
        });

        btnNotifications.setOnClickListener(v -> {
            // Handle Notifications click
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show();
        });

        btnPreferences.setOnClickListener(v -> {
            // Handle Preferences click
            Toast.makeText(this, "Preferences clicked", Toast.LENGTH_SHORT).show();
        });

        btnLogout.setOnClickListener(v -> {
            // Handle logout
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MenuActivity.this, MainActivity.class));
            finish();
        });

        // Set user data
        txtUserName.setText("User Full Name");
        // You can load the profile image using a library like Glide or Picasso
        // For now, we're using a placeholder
    }
}
