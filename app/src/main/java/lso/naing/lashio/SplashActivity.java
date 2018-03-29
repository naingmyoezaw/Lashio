package lso.naing.lashio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    long Delay=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer RunSplash=new Timer();

        TimerTask ShowScreen=new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent=new Intent(SplashActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        };
        RunSplash.schedule(ShowScreen,Delay);
    }
}
