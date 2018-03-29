package lso.naing.lashio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutActivity extends AppCompatActivity {

    ImageButton facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        facebook=(ImageButton)findViewById(R.id.img_facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=OpenFacebook(AboutActivity.this);
                startActivity(intent);

            }
        });
    }

    public static Intent OpenFacebook(Context context){
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.facebook.com/mobilefirmwarepaid"));
        }catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.facebook.com/mobilefirmwarepaid"));

        }
    }

}
