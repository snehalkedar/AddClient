package tv.techm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.mcsoxford.rss.*;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import tv.techm.content.Config;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class AddClientService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
 		boolean ShowAdd = intent.getBooleanExtra("tv.techm.ShowAdd",false);
if(!ShowAdd)
{		RSSReader reader = new RSSReader();
		  String uri = Config.getAddServerUrl(getApplicationContext());//"http://10.0.2.2/advertisement.htm";
		//  String uri = "http://10.10.135.130/advertisement/index/rss";
try{
			RSSFeed feed = reader.load(uri);
			java.util.List<RSSItem> items=  feed.getItems();
			
 	for(int i=0;i<items.size();i++){
		RSSItem item= (RSSItem)items.get(i);
		Log.i("add server__________", "new add ");
		FileOutputStream fos = openFileOutput("add"+i, this.MODE_WORLD_READABLE);
		OutputStreamWriter osw =new OutputStreamWriter(fos);
	        osw.write(item.getDescription());
  		osw.close();  
		fos.close();
               
				/*BufferedWriter bufferedWriter = null;
				
				bufferedWriter = new BufferedWriter(new FileWriter("/data/data/tv.techm/files/add"+i));
				

				
				//Log.i("RSSReader__________", "item  title : "+item.getTitle());
				//bufferedWriter.write(item.getTitle());
				Log.i("RSSReader__________", "item  description : "+item.getDescription());
				bufferedWriter.write(item.getDescription());
				  
				bufferedWriter.newLine();
				bufferedWriter.flush();
				bufferedWriter.close();
		//		webview.loadData(item.getDescription(), "text/html", null);
		//		Log.i("RSSReader__________", "item  link : "+item.getLink());*/
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
else{
	Log.i("add server__________", "displaying add ");
	Intent i= new Intent(this,DisplayActivity.class);
	i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	startActivity(i);
}

		return START_STICKY;
		
	}
}
