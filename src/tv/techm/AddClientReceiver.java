package tv.techm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import tv.techm.Global;

public class AddClientReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
        if (action.equals(Global.ACTION_AUTHENTICATION)) {
            startService(context);
        }
    }
/***
 * Start the AdcClient service on BOOT_COMPLETE
 */
    private void startService(Context context) {
    Intent collectAdd=new Intent(context, AddClientService.class);

   collectAdd.putExtra("tv.techm.ShowAdd",false);
        context.startService(collectAdd);
    }
}
