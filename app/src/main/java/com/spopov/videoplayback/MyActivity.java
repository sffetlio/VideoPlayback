package com.spopov.videoplayback;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.VideoView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        final ImageView play = (ImageView) findViewById(R.id.play);
        final ImageView pause = (ImageView) findViewById(R.id.pause);
        final ImageView prev = (ImageView) findViewById(R.id.prev);
        final ImageView next = (ImageView) findViewById(R.id.next);
        final ToggleButton videoLocation = (ToggleButton) findViewById(R.id.videoLocation);

        videoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName() +"/"+R.raw.video));

        videoLocation.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();
                videoView.stopPlayback();
                if(on){
                    videoView.setVideoURI(Uri.parse("https://github.com/HackBulgaria/Android-1/raw/master/week0/1-Widgets/Ronaldo_Dive_Moti.mp4"));
                }else{
                    videoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName() +"/"+R.raw.video));
                }
            }
        });

        play.setOnClickListener(new ImageView.OnClickListener() {

            @Override
            public void onClick(View view) {
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
                videoView.start();
            }
        });

        pause.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View view) {
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                videoView.pause();
            }
        });

        prev.setOnClickListener(new ImageView.OnClickListener() {

            @Override
            public void onClick(View view) {
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                videoView.pause();
                videoView.seekTo(videoView.getCurrentPosition() - 3000);
            }
        });

        next.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View view) {
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                videoView.pause();
                videoView.seekTo(videoView.getCurrentPosition() + 3000);
            }
        });
    }
}
