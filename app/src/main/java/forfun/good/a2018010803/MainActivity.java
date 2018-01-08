package forfun.good.a2018010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    //String str[] = {"AA", "BB", "CCC", "DDDD", "EEEEE"};
    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean chks[] = new boolean[10]; //布林陣列
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);


        HashMap<String, Object> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        m1.put("img", R.drawable.taipei);
        mylist.add(m1);
        HashMap<String, Object> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        m2.put("img", R.drawable.taichung);
        mylist.add(m2);
        HashMap<String, Object> m3 = new HashMap<>();
        m3.put("city", "台南");
        m3.put("code", "05");
        m3.put("img", R.drawable.tainan);
        mylist.add(m3);
        HashMap<String, Object> m4 = new HashMap<>();
        m4.put("city", "高雄");
        m4.put("code", "07");
        m4.put("img", R.drawable.kao);
        mylist.add(m4);
        HashMap<String, Object> m5 = new HashMap<>();
        m5.put("city", "屏東");
        m5.put("code", "08");
        m5.put("img", R.drawable.pington);
        mylist.add(m5);

        HashMap<String, Object> m6 = new HashMap<>();
        m6.put("city", "台北2");
        m6.put("code", "202");
        m6.put("img", R.drawable.taipei);
        mylist.add(m6);
        HashMap<String, Object> m7 = new HashMap<>();
        m7.put("city", "台中2");
        m7.put("code", "204");
        m7.put("img", R.drawable.taichung);
        mylist.add(m7);
        HashMap<String, Object> m8 = new HashMap<>();
        m8.put("city", "台南2");
        m8.put("code", "205");
        m8.put("img", R.drawable.tainan);
        mylist.add(m8);
        HashMap<String, Object> m9 = new HashMap<>();
        m9.put("city", "高雄2");
        m9.put("code", "207");
        m9.put("img", R.drawable.kao);
        mylist.add(m9);
        HashMap<String, Object> m10 = new HashMap<>();
        m10.put("city", "屏東");
        m10.put("code", "08");
        m10.put("img", R.drawable.pington);
        mylist.add(m10);

        MyAdapter adapter = new MyAdapter();
        lv.setAdapter(adapter);

    }
    public void CL1(View v)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chks.length;i++)
        {
            if (chks[i])
            {
                sb.append(mylist.get(i).get("city")+","); //
            }
        }
        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_LONG).show();}

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mylist.size(); //因為是物件
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            Log.d("GetView","position"+ position);
            View v = inflater.inflate(R.layout.myui2,null);

            TextView tv = v.findViewById(R.id.textView);
            tv.setText(mylist.get(position).get("city").toString());//找到位子後轉String
            TextView tv2 = v.findViewById(R.id.textView2);
            tv2.setText(mylist.get(position).get("code").toString());//找到code轉
            ImageView img = v.findViewById(R.id.imageView);
            img.setImageResource((Integer) mylist.get(position).get("img"));//載入圖片
            CheckBox cb = v.findViewById(R.id.checkBox);

            cb.setChecked(chks[position]);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    chks[position] = isChecked;
                }
            });
            return  v;
            /*
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View v = inflater.inflate(R.layout.myui,null); //設定指向自設layout

            TextView tv = v.findViewById(R.id.textView3);
            tv.setText(str[position]);
            return v;
            */


            /*
            TextView tv = new TextView(MainActivity.this);
            tv.setText(str[position] + position);
            return tv;
            使用系統的Textview
            */


        }
    }
}
