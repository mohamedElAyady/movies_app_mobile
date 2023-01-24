package com.example.movies_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Video_Streaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_streaming);

        VideoView videoView = (VideoView) findViewById(R.id.video);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);



        Uri video = Uri.parse("https://firebasestorage.googleapis.com/v0/b/movies-app-67981.appspot.com/o/VID-20210514-WA0000.mp4?alt=media&token=0176e670-ca63-43f9-b379-1ac943870e8b");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();
    }
}