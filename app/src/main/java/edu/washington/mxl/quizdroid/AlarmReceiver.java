package edu.washington.mxl.quizdroid; /**
 * Created by Michelle on 2/24/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("onReceive", "ENTERED");
        String message = intent.getStringExtra("message");
        // For our recurring task, we'll just display a message
        if (message != null) {
            Log.i("onReceive", message);
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}