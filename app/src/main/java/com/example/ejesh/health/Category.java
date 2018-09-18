package com.example.ejesh.health;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Category extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int RESULT_LOAD_IMAGE = 1;
    NavigationView navigationView;
    View HeaderView;
    TextView username;
    ImageView userImage;
    public static Toolbar toolbar;
    GridLayout mainGrid;

    private DrawerLayout drawer;
    HealthilyPreference healthilyPreference;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        drawer = findViewById(R.id.drawer_layout);

        healthilyPreference = new HealthilyPreference(this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        HeaderView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Today's Category");
        userImage = HeaderView.findViewById(R.id.imgView);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });


        //View
        username = HeaderView.findViewById(R.id.textViewUser);
        //Set Username
        username.setText(healthilyPreference.getAccountName());


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        age = healthilyPreference.getAccountAge();
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.logout) {

            Logout();  //Logout code


        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    public void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(Category.this, zumba.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        if (Integer.valueOf(age) > 15 && Integer.valueOf(age) <= 21) {

                            Toast.makeText(Category.this, "YOua rea a teenager", Toast.LENGTH_SHORT).show();


                        }

                        Intent intent = new Intent(Category.this, workout.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(Category.this, meditation.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(Category.this, yoga.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Category.this, "Please select a category", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    public void Logout() {
        healthilyPreference.hasLoggedIn(false);

        startActivity(new Intent(Category.this, SignUp.class));
        this.finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            userImage.setImageURI(selectedImage);

        }
    }
}
