package com.example.activitytest;


import java.security.PublicKey;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;


public class activityTest extends Activity {

	public static String phoneNumber;
	public static String displayInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.i(getPackageName(), getClass().getName());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_1);
		
		
		
		
		Button button1 = (Button)findViewById(R.id.start_timer);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(activityTest.this, "you seems want to input phone number", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getPackageName()+".SECOND");
				startActivity(intent);
			}
		});
		
		Button button2 = (Button)findViewById(R.id.button_info_display);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(activityTest.this, "you seems want to input display", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getPackageName()+".THIRD");
				startActivity(intent);
			}
		});
		
		Button button3 = (Button)findViewById(R.id.button_dial_out);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (phoneNumber.length() == 0) {					
					Toast.makeText(activityTest.this, "You have not input phone number", Toast.LENGTH_SHORT).show();
				}
				if (displayInfo.length() == 0) {					
					Toast.makeText(activityTest.this, "You have not input display info", Toast.LENGTH_SHORT).show();
				} else {
					NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
					Notification notification = new Notification(R.drawable.ic_launcher, "display info", System.currentTimeMillis());
					notification.setLatestEventInfo(activityTest.this, "display info", activityTest.displayInfo, null);
					manager.notify(1, notification);
				}
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:"+activityTest.phoneNumber));
				startActivity(intent);
			}
		});
		
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.exit_item:
			finish();
			break;
		default:
			Log.w("adc", "nothing clicked");
			break;
		}
		return true;
	}


}

