package com.example.activitytest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_2);

		Button button_2 = (Button)findViewById(R.id.button_phoneNumber);
		button_2.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				EditText input_text = (EditText)findViewById(R.id.phone_number);
				activityTest.phoneNumber = input_text.getText().toString();
				if (activityTest.phoneNumber.length() != 0) {
					Toast.makeText(secondActivity.this, "saved", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(secondActivity.this, "no phone number", Toast.LENGTH_SHORT).show();
				}
				finish();
			}
		});
	}
	
	
}
