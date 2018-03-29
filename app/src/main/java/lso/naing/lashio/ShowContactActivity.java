package lso.naing.lashio;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowContactActivity extends AppCompatActivity {

    TextView number1,number2,number3,nametitle;
    ImageButton call1,call2,call3;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        number1=(TextView)findViewById(R.id.phnumber1_id);
        number2=(TextView)findViewById(R.id.phnumber2_id);
        number3=(TextView)findViewById(R.id.phnumber3_id);
        nametitle=(TextView)findViewById(R.id.name_title_id);

        call1=(ImageButton)findViewById(R.id.call_star1_id);
        call2=(ImageButton)findViewById(R.id.call_star2_id);
        call3=(ImageButton)findViewById(R.id.call_star3_id);

        img=(ImageView)findViewById(R.id.img_view);
        final String imgview=getIntent().getExtras().get("imgbg").toString();
        img.setImageResource(Integer.parseInt(imgview));

        final String contacttitle=getIntent().getExtras().get("NameTitle").toString();
        nametitle.setText(contacttitle);

        final String  phnumber1=getIntent().getExtras().get("PhNumber1").toString();
        number1.setText(phnumber1);

        final String phnumber2=getIntent().getExtras().get("PhNumber2").toString();
        number2.setText(phnumber2);

        final String phnumber3=getIntent().getExtras().get("PhNumber3").toString();
        number3.setText(phnumber3);


        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+phnumber1)));
                Toast.makeText(ShowContactActivity.this,"ဖုန္းေခၚေနသည္...",Toast.LENGTH_SHORT).show();
            }
        });

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+ phnumber2)));
                Toast.makeText(ShowContactActivity.this,"ဖုန္းေခၚေနသည္...",Toast.LENGTH_SHORT).show();
            }
        });

        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+ phnumber3)));
                Toast.makeText(ShowContactActivity.this,"ဖုန္းေခၚေနသည္...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
