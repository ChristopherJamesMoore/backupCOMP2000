package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView companyNameText, userFullNameText, statusText, emailText, bossNameText;
    private TextView firstNameText, lastNameText, phoneText, postcodeText, streetText, cityText;
    private ImageView profileImage;
    private Button editButton;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        initializeViews();

        // Set dummy data
        setDummyData();

        // Set edit button click listener
        editButton.setOnClickListener(v -> {
            // Handle edit button click
            Toast.makeText(this, "Edit clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, EditActivity.class));
            finish();
        });

        profileImage.setOnClickListener(v -> {
            // Handle edit button click
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, MenuActivity.class));
        });

        menuButton.setOnClickListener(v -> {
            // Handle edit button click
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, MenuActivity.class));
        });
    }

    private void initializeViews() {
        // Company card views
        companyNameText = findViewById(R.id.companyName);
        userFullNameText = findViewById(R.id.userFullName);
        statusText = findViewById(R.id.status);
        emailText = findViewById(R.id.email);
        bossNameText = findViewById(R.id.bossName);
        profileImage = findViewById(R.id.profileImage);

        // Personal information card views
        firstNameText = findViewById(R.id.firstName);
        lastNameText = findViewById(R.id.lastName);
        phoneText = findViewById(R.id.phone);
        postcodeText = findViewById(R.id.postcode);
        streetText = findViewById(R.id.street);
        cityText = findViewById(R.id.city);
        editButton = findViewById(R.id.editBtn);
        menuButton = findViewById(R.id.menuBtn);
    }

    private void setDummyData() {
        // Set company information
        companyNameText.setText("Company Name");
        userFullNameText.setText("User Full Name");
        statusText.setText("Active");
        emailText.setText("Example@company.ac.uk");
        bossNameText.setText("Boss Name");

        // Set personal information
        firstNameText.setText("User First Name");
        lastNameText.setText("User Last Name");
        phoneText.setText("+44 123456789");
        postcodeText.setText("SW1A 0AA");
        streetText.setText("Abingdon St");
        cityText.setText("London");
    }
}