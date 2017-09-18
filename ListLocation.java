package ivancorp.menuslidenavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListLocation extends AppCompatActivity {

    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "LABSI Kelapa Dua", "LABSI Kalimalang", "LABSI Karawaci", "LABSI Cengkareng",
            "iLab", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };


    int[] listviewImage = new int[]{
            R.drawable.iconlabsikd, R.drawable.iconlabsikmg, R.drawable.iconlabsikwc,R.drawable.iconlabsickg,R.drawable.iconilab
    };

    String[] listviewShortDescription = new String[]{
            "Jln Akses UI Kelapa Dua, Cimanggis, Depok 16951 Jawa Barat - Indonesia",
            "Jl. KH. Noer Ali (Dekat kolam renang jakasampurna), Kalimalang, Bekasi, Jawa Barat, Indonesia",
            "Jl. Danau Kelapa Dua (Sebelah kompleks Islamic Village), Karawaci, Banten, Indonesia",
            "City Resort Boulevard, Jl. Raya Kamal Outring Road No.75, Cengkareng, Tangerang, Banten, Indonesia",
            "Jln Akses UI Kelapa Dua, Cimanggis, Depok 16951 Jawa Barat - Indonesia",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmodule);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_adapter, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(i == 0){
                    Intent a = new Intent(view.getContext(),LokasiKD.class);
                    startActivity(a);
                }
                if(i == 1){
                    Intent a = new Intent(view.getContext(),LokasiKML.class);
                    startActivity(a);
                }
                if(i == 2){
                    Intent a = new Intent(view.getContext(),LokasiKWC.class);
                    startActivity(a);
                }
                if(i == 3){
                    Intent a = new Intent(view.getContext(),LokasiCKG.class);
                    startActivity(a);
                }
                if(i == 4){
                    Intent a = new Intent(view.getContext(),LokasiIlab.class);
                    startActivity(a);
                }
            }
        });

    }
}