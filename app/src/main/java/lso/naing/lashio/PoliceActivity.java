package lso.naing.lashio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PoliceActivity extends AppCompatActivity {

    private String[] name={"ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၁)","ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၂)","ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၃)","ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၄)"};
    private String [] number={"0949770366","0949772194","09425002365","09253100322"};

    ListView lv;
    private List<MyAdapter> mAdapter;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv=(ListView)findViewById(R.id.list_id);

        mAdapter=new ArrayList<>();

        mAdapter.add(new MyAdapter(1,"ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၁)","0949770366",R.drawable.police_logo));
        mAdapter.add(new MyAdapter(2,"ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၂)","0949772194",R.drawable.police_logo));
        mAdapter.add(new MyAdapter(2,"ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၃)","09425002365",R.drawable.police_logo));
        mAdapter.add(new MyAdapter(2,"ရဲတပ္ဖြဲ့ဖုန္းနံပါတ္(၄)","09253100322",R.drawable.police_logo));

        adapter=new ListAdapter(getApplicationContext(),mAdapter);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+ number[i])));
                Toast.makeText(PoliceActivity.this,"ဖုန္းေခၚေနသည္...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
