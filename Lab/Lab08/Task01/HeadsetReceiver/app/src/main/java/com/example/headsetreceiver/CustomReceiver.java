package com.example.headsetreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction) {
                case Intent.ACTION_HEADSET_PLUG :
                    int state = intent.getIntExtra("state", -1);
                    switch (state) {
                        case 0:
                            toastMessage = "Headset unplugged";

                            break;
                        case 1:
                            toastMessage = "Headset plugged";

                            break;
                    }
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}