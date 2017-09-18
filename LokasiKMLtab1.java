package ivancorp.menuslidenavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;


public class LokasiKMLtab1 extends Fragment {
    Button gpeta;

    public LokasiKMLtab1(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_lokasi_kmltab1, container, false);

        gpeta = (Button) rootView.findViewById(R.id.bpeta);

        gpeta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(v.getContext(), MapsKML.class);

                startActivity(i);
            }
        });
        WebView a = (WebView)rootView.findViewById(R.id.webView);
        WebSettings webSettings = a.getSettings();
        webSettings.setJavaScriptEnabled(true);
        a.loadUrl("file:///android_asset/labJ.html");
        return  rootView;
    }

}