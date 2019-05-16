package hackathontw.com.br.hackathontw;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class HistoryActivity extends Activity
{

    private Integer level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                level = null;
            } else {
                level = extras.getInt("level");
            }
        } else {
            level = (Integer) savedInstanceState.getSerializable("level");
        }

        this.chooseHistoryByLevel(level);

        /*final Button btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ImageView image = (ImageView) findViewById(R.id.imgHistory);
                Bitmap icon = ((BitmapDrawable)image.getDrawable()).getBitmap();

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.jpg"));
                startActivity(Intent.createChooser(share, "Share Image"));
            }
        });
        */

        final ImageView btnStart = (ImageView) findViewById(R.id.iniciar);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent quiz = new Intent(HistoryActivity.this, CardQuizActivity.class);
                quiz.putExtra("level",level);
                startActivity(quiz);
                finish();
            }
        });
    }

    private void chooseHistoryByLevel(int level){
        ImageView map = (ImageView) findViewById(R.id.imgHistory);
        switch (level){
            case 1:
                map.setImageResource(R.drawable.history01);
                break;
            case 2:
                map.setImageResource(R.drawable.history02);
                break;
            case 3:
//                map.setBackgroundResource(R.drawable.history03);
                break;
            case 4:
//                map.setBackgroundResource(R.drawable.history04);
                break;
            case 5:
//                map.setBackgroundResource(R.drawable.history05);
                break;
        }
    }
}