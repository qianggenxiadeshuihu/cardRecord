package com.example.activitytest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class thirdActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_3);

		Button button_3 = (Button)findViewById(R.id.button_dispalyInfo);
		button_3.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText input_text = (EditText)findViewById(R.id.display_info);
				activityTest.displayInfo = input_text.getText().toString();
				if (activityTest.displayInfo.length() != 0) {
					Toast.makeText(thirdActivity.this, "saved", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(thirdActivity.this, "no display info", Toast.LENGTH_SHORT).show();
				}
				finish();
			}
		});
	}
}
