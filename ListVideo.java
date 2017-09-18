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

public class ListVideo extends AppCompatActivity {



    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "PHP", "HTML", "JavaScript", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };


    int[] listviewImage = new int[]{
            R.drawable.phplogo, R.drawable.htmllogo, R.drawable.javascripticon,
    };

    String[] listviewShortDescription = new String[]{
            "Video Pembelajaran PHP Web Programming untuk pemula, tutorial php dengan menggunakan bahasa indonesia",
            "Video Pembelajaran mengenai dasar dasar HTML dan tag-tag yang ada pada HTML.",
            "Video Pembelajaran dasar JavaScript untuk pemula",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 3; i++) {
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
                    Intent a = new Intent(view.getContext(),VideoPhp.class);
                    startActivity(a);
                }
                if(i == 1){
                    Intent a = new Intent(view.getContext(),VideoHtml.class);
                    startActivity(a);
                }
                if(i == 2){
                    Intent a = new Intent(view.getContext(),VideoJavascript.class);
                    startActivity(a);
                }

            }
        });

    }
}

