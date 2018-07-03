package casinofun.software.ass.musicapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import jp.wasabeef.blurry.Blurry;

public class SongActivity extends AppCompatActivity {
     ImageView imageBg, home;
     RelativeLayout relative;
    String URL="https://cdn.pixabay.com/photo/2017/10/25/09/12/background-2887350_960_720.jpg";

    int[] images1 = {R.drawable.pla, R.drawable.pla, R.drawable.pla, R.drawable.pla, R.drawable.pla, R.drawable.pla, R.drawable.pla};
    int[] images2 = {R.drawable.download, R.drawable.download, R.drawable.download, R.drawable.download, R.drawable.download, R.drawable.download, R.drawable.download};

    String[] version = {"Gerua ( From Dilwale )", "Manma Emotional Jaage", "Janam Janam", "Tukur Tukur", "Daayre", "Janam Janam", "Tukur Tukur"};
    String[] versionNumber = {"Pritam, Arijit Singh, Antara mitra", "Pritam, Arijit Singh", "Pritam, Arijit Singh", "Pritam, Arijit Singh, Antara mitra", "Pritam, Arijit Singh, Antara mitra", "Pritam, Arijit Singh, Antara mitra", "Pritam, Arijit Singh"};

    ListView lView;

    ListAdapter lAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        imageBg = (ImageView)findViewById(R.id.imageBg);
        home=(ImageView)findViewById(R.id.home);
        relative=(RelativeLayout)findViewById(R.id.relative);
        Picasso.with(getApplicationContext()).load(URL).into(imageBg);
        home=(ImageView)findViewById(R.id.home);
    //    Blurry.with(getApplicationContext()).capture(relative).into(imageBg);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lView = (ListView) findViewById(R.id.musicList);

        lAdapter = new ListAdapter(SongActivity.this, version, versionNumber, images1,images2);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(SongActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
