package com.example.movies_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Movie> actionList = new ArrayList<Movie>();
    ArrayList<Movie> kdramaList = new ArrayList<Movie>();
    ArrayList<Movie> horrorList = new ArrayList<Movie>();

    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase myRef = FirebaseDatabase.getInstance("https://movies-app-67981-default-rtdb.europe-west1.firebasedatabase.app/");


        myRef.getReference("kdrama").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Movie value = postSnapshot.getValue(Movie.class);
                    kdramaList.add(value);
                    kdrama(kdramaList);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        myRef.getReference("action").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Movie value = postSnapshot.getValue(Movie.class);
                    actionList.add(value);
                    Action(actionList);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        myRef.getReference("horror").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Movie value = postSnapshot.getValue(Movie.class);
                    horrorList.add(value);
                    horror(horrorList);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });






        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                System.out.println(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


    }

    private void Action( ArrayList<Movie> arrayList){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(layoutManager);
        HomeAdapter adapter = new HomeAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setAdapter(adapter);
    }

    private void kdrama( ArrayList<Movie> arrayList){
        SeriesAdapter adapter = new SeriesAdapter(this, arrayList);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter);
    }
    private void horror( ArrayList<Movie> arrayList){
        HomeAdapter adapter = new HomeAdapter(this, arrayList);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter);

    }


}