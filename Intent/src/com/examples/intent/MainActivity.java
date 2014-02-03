package com.examples.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button clickButton = (Button) findViewById(R.id.buttonClickButton);
        clickButton.setOnClickListener(new OnClickListener() {
   
   @Override
   public void onClick(View v) {
    Intent secondActivity = new Intent(getBaseContext(), SecondActivity.class);
    startActivity(secondActivity);
   }
  });
    }
}

