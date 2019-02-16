package com.example.bruno.onlinecoach.Student;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.bruno.onlinecoach.Objects.Exercise;
import com.example.bruno.onlinecoach.R;

public class MainActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        MainMenuFragment.OnFragmentInteractionListener,
        WeightListFragment.OnWeightListFragmentInteractionListener,
        ExerciseListFragment.OnExerciseListFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener {

    FrameLayout main_frame;
    public static final String menuFragmentTag = "main_menu_fragment";
    public static final String weightListFragmentTag = "weight_list_fragment";
    public static final String exerciseListFragmentTag = "exercise_list_fragment";
    public static final String profileFragmentTag = "profile_fragment";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        main_frame = findViewById(R.id.frame);

        //int userType = getIntent().getExtras().getInt("userType");


        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(menuFragmentTag)
                .replace(R.id.frame, mainMenuFragment, menuFragmentTag)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int count = getFragmentManager().getBackStackEntryCount();

            if (count == 0) {
                super.onBackPressed();
                main_frame = findViewById(R.id.frame);
                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack(menuFragmentTag)
                        .replace(R.id.frame, mainMenuFragment, menuFragmentTag)
                        .commit();
            } else {
                getFragmentManager().popBackStack();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            ProfileFragment profileFragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().addToBackStack(profileFragmentTag).replace(R.id.frame, profileFragment, profileFragmentTag).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMenuFragmentInteraction(int i) {
        switch(i){
            case 1:
                Toast.makeText(this, "Option " + i + " pressed", Toast.LENGTH_SHORT).show();
                WeightListFragment weightListFragment = new WeightListFragment();
                getSupportFragmentManager().beginTransaction().addToBackStack(weightListFragmentTag).replace(R.id.frame, weightListFragment, weightListFragmentTag).commit();
                break;
            case 2:
                Toast.makeText(this, "Option " + i + " pressed", Toast.LENGTH_SHORT).show();
                ExerciseListFragment exerciseListFragment = new ExerciseListFragment();
                getSupportFragmentManager().beginTransaction().addToBackStack(exerciseListFragmentTag).replace(R.id.frame, exerciseListFragment, exerciseListFragmentTag).commit();
                break;
            case 3:
                Toast.makeText(this, "Option " + i + " pressed", Toast.LENGTH_SHORT).show();
                ProfileFragment profileFragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().addToBackStack(profileFragmentTag).replace(R.id.frame, profileFragment, profileFragmentTag).commit();
                break;
            default:
                Toast.makeText(this, "Choose an option", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onWeightListFragmentInteraction(Uri uri) {

    }

    @Override
    public void onExerciseListFragmentInteraction(Exercise item) {

        final AlertDialog.Builder inputAlert = new AlertDialog.Builder(this);
        inputAlert.setTitle(item.getName());
        inputAlert.setMessage("Today's input");
        final EditText userInput = new EditText(getBaseContext());
        inputAlert.setView(userInput);
        inputAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userInputValue = userInput.getText().toString();
                Toast.makeText(getBaseContext(), userInputValue + " updated", Toast.LENGTH_SHORT).show();
            }
        });
        inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = inputAlert.create();
        alertDialog.show();
    }

    @Override
    public void onProfileFragmentInteraction(Uri uri) {

    }

}
