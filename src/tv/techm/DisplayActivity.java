package tv.techm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Random;
import java.io.File;
import android.net.Uri;
import android.webkit.WebViewClient;
import java.util.Timer;
import java.util.TimerTask;
import android.graphics.Color;


public class DisplayActivity extends Activity {

	boolean dismiss=false;
Timer t;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.web);
	        WebView webview = (WebView) findViewById(R.id.webview);
	        WebSettings webSettings = webview.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        
	        
	        try {
Log.i("DisplayActivity__________", "Showing add now........ ");
			File directory= new File("/data/data/tv.techm/files/");
			int noOfFiles = directory.listFiles().length;
				int random=new Random().nextInt(noOfFiles);
				BufferedReader buf = new BufferedReader(new FileReader("/data/data/tv.techm/files/add"+random));
				String str=null;
				String addvertisementContent="";
				while ((str = buf.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (str);
					  addvertisementContent+=str;
					  
					  }
				webview.loadData(addvertisementContent, "text/html", null);
				webview.setBackgroundColor(Color.BLACK);
 				t=new Timer();
     				t.schedule(new TimerTask() {

					public void run() {
						finish();
					}
				}, 15*1000);
			
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	  }


private class MyWebViewClient extends WebViewClient {
    
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
	finish();
        return true;
    }
}
}
