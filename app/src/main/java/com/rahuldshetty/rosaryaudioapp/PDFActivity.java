package com.rahuldshetty.rosaryaudioapp;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.rahuldshetty.rosaryaudioapp.models.SubTitles;

import java.io.InputStream;

public class PDFActivity extends AppCompatActivity {

    private PDFView pdfView;

    private SeekBar seekBar;
    private ImageView playBtn;
    private TextView title,start,end;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfView = findViewById(R.id.pdf_viewer);
        seekBar = findViewById(R.id.player_seek);
        playBtn = findViewById(R.id.player_play);
        title = findViewById(R.id.player_title);
        start= findViewById(R.id.player_start);
        end = findViewById(R.id.player_end);

        SubTitles subTitle = (SubTitles) getIntent().getParcelableExtra("SUB");

        title.setText(subTitle.getTitle());
        if(!subTitle.getType().equals("eng"))
        {
            Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.nudi01ebold);
            title.setTypeface(typeface);
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        }



        try {
            InputStream inputStream = getAssets().open(subTitle.getPath());
            pdfView.fromStream(inputStream)
                    .defaultPage(0)
                    .autoSpacing(true)
                    .enableAntialiasing(true)
                    .load();
        }
        catch (Exception e){

        }

    }
}
