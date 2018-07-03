package casinofun.software.ass.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageBg;
    String URL="https://cdn.pixabay.com/photo/2017/10/25/09/12/background-2887350_960_720.jpg";
    RelativeLayout songs, videos, wallpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageBg=(ImageView)findViewById(R.id.imageBg);
        songs=(RelativeLayout)findViewById(R.id.songs);
        videos=(RelativeLayout)findViewById(R.id.videos);
        wallpaper=(RelativeLayout)findViewById(R.id.wallpaper);
        Picasso.with(getApplicationContext()).load(URL).into(imageBg);
        songs.setOnClickListener(this);
        videos.setOnClickListener(this);
        wallpaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.songs:
            startActivity(new Intent(getApplicationContext(), SongActivity.class));
                break;

            case R.id.videos:
                startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                break;

            case R.id.wallpaper:
                startActivity(new Intent(getApplicationContext(), WallpaperActivity.class));
                break;
        }
    }
}
