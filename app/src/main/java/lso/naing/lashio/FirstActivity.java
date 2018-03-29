package lso.naing.lashio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    Button first1,first2,first3;
    private final int CALL_REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        askpermission(Manifest.permission.CALL_PHONE,CALL_REQUEST_CODE);

        first1=(Button)findViewById(R.id.first1_id);
        first2=(Button)findViewById(R.id.police_id);

        first1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
            }
        });

        first2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstActivity.this,PoliceActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
            }
        });
    }


    public void askpermission(String permission,int request){
        if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{permission},request);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case CALL_REQUEST_CODE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_DENIED);
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.about_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.about_id){

            Intent intent=new Intent(FirstActivity.this,AboutActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_left,R.anim.slide_right);

        }
        return super.onOptionsItemSelected(item);
    }
    public void OnClick(){
        this.overridePendingTransition(R.anim.slide_left,R.anim.slide_left);
    }
}
