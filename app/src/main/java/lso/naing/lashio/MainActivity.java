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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyAdapter> mAdapter;
    private ListAdapter adapter;
    ListView list;


    private String[] Name={"KBZ ကူညီမႈ့အသင္း","လားရႈိးလူငယ္မ်ား","ေစတနာမြန္လူငယ္မ်ား"};
    private String [] Number1={"09260118522","095262437","09784676546"};
    private String [] Number2={"09448955233","09788285900","09782253083"};
    private String[] Number3={"09770400775","09403730774","09786038151"};
    private int[] image={R.drawable.kbz_bg,R.drawable.young_bg,R.drawable.saytanar_bg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("လူမႈကူညီမူအသင္းမ်ား (Lashio)");



        list=(ListView)findViewById(R.id.listview_id);

        mAdapter=new ArrayList<>();

        mAdapter.add(new MyAdapter(1,"KBZ နာေရး ႏွင့္ လူမႈကူညီေရးအသင္း လားရႈိးျမိဳ ႔","KBZ(CBO),Lashio,NSS",R.drawable.kbz));
        mAdapter.add(new MyAdapter(2,"လူငယ္မ်ား လူမႈကူညီေရးအသင္း(ရွမ္း/ေျမာက္)","ရွမ္းျပည္နယ္ ေျမာက္ပိုင္း လားရႈိးျမဳိ ႔",R.drawable.young));
        mAdapter.add(new MyAdapter(3,"ေစတနာမြန္ လူငယ္ေသြးလွဴ ရွင္မ်ားအသင္း လားရႈိးျမို ႔","အသင္းအဖြဲ့မွတ္ပံုတင္အမွတ္- ၆။လားရႈိး။၀၁၀",R.drawable.saytanar));


        adapter=new ListAdapter(getApplicationContext(),mAdapter);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(MainActivity.this,ShowContactActivity.class);
                intent.putExtra("NameTitle",Name[i]);
                intent.putExtra("PhNumber1",Number1[i]);
                intent.putExtra("PhNumber2",Number2[i]);
                intent.putExtra("PhNumber3",Number3[i]);
                intent.putExtra("imgbg",image[i]);
                startActivity(intent);
            }
        });
    }


}
