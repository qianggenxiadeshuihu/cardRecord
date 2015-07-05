package com.example.activitytest;


import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

import android.R.string;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.StaticLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.FlagToString;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;


public class activityTest extends Activity {

	public static Timer global_time;
	public static int flag = 0;
	public static int count_A = 0;
	public static int count_B = 0;
	public static int count_C = 0;
	public static int count_D = 0;
	
	public static TextView name_a;
	public static TextView name_b;
	public static TextView name_c;
	public static TextView name_d;
	

	public static TextView name_A;
	public static TextView name_B;
	public static TextView name_C;
	public static TextView name_D;
	

	public static TextView count_a;
	public static TextView count_b;
	public static TextView count_c;
	public static TextView count_d;

	public static TimerTask t_task;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.i(getPackageName(), getClass().getName());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_1);
		

		name_a = (TextView)findViewById(R.id.name_a);
		name_b = (TextView)findViewById(R.id.name_b);
		name_c = (TextView)findViewById(R.id.name_c);
		name_d = (TextView)findViewById(R.id.name_d);
		
		name_A = (EditText)findViewById(R.id.name_A);
		name_B = (EditText)findViewById(R.id.name_B);
		name_C = (EditText)findViewById(R.id.name_C);
		name_D = (EditText)findViewById(R.id.name_D);
		
		count_a = (TextView)findViewById(R.id.count_a);
		count_b = (TextView)findViewById(R.id.count_b);
		count_c = (TextView)findViewById(R.id.count_c);
		count_d = (TextView)findViewById(R.id.count_d);

		
		global_time = new Timer();
		
		final Handler my_handler = new Handler() {
			@Override
			public void handleMessage(Message msg)
			{
				super.handleMessage(msg);
				if (msg.what == 100)
				{
					activityTest.count_a.setText(String.valueOf(count_A));
					activityTest.count_b.setText(String.valueOf(count_B));
					activityTest.count_c.setText(String.valueOf(count_C));
					activityTest.count_d.setText(String.valueOf(count_D));
					return;
				}
				switch (flag)
				{
				case 0:
					activityTest.name_a.setText(activityTest.name_A.getText().toString());
					activityTest.count_a.setText(String.valueOf(count_A));
					break;
				case 1:
					activityTest.name_b.setText(activityTest.name_B.getText().toString());
					activityTest.count_b.setText(String.valueOf(count_B));
					break;
				case 2:
					activityTest.name_c.setText(activityTest.name_C.getText().toString());
					activityTest.count_c.setText(String.valueOf(count_C));
					break;
				case 3:
					activityTest.name_d.setText(activityTest.name_D.getText().toString());
					activityTest.count_d.setText(String.valueOf(activityTest.count_D));
					break;
				}
			}
		};
		
		
		Button button1 = (Button)findViewById(R.id.start_timer);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t_task = new TimerTask() {	
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Message msg = new Message();
						
						switch (flag)
						{
						case 0:
							count_A += 1;
							msg.what = count_A;
							break;
						case 1:
							count_B += 1;
							msg.what = count_B;
							break;
						case 2:
							count_C += 1;
							msg.what = count_C;
							break;
						case 3:
							count_D += 1;
							msg.what = count_D;
							break;
						default:
							Log.e("hi", "overflow for flag");
						}
						my_handler.sendMessage(msg);
					}
				};
				global_time.scheduleAtFixedRate(t_task, 0, 1000);		
			}
		});
		
		Button button2 = (Button)findViewById(R.id.stop_timer);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t_task.cancel();
				
			}
		});
		
		Button button3 = (Button)findViewById(R.id.reset_timer);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_A = 0;
				count_B = 0;
				count_C = 0;
				count_D = 0;
				flag = 0;
				Message msg = new Message();
				msg.what = 100;
				my_handler.sendMessage(msg);
			}
		});
		
		Button button4 = (Button)findViewById(R.id.switch_beginner);
		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flag = (flag+1) % 4;  
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

