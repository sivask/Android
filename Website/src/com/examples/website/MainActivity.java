package com.examples.website;

import com.examples.website.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity {

	WebView website; 
    Button Home;  	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);
		
	WebView website = (WebView)findViewById(R.id.webView1);
	   
	website.getSettings().setJavaScriptEnabled(true);  
	
	website.loadUrl("http://news.google.com/");
	
	}
	
}



//  public void onCreate(Bundle savedInstanceState) 
	//{
//  super.onCreate(savedInstanceState);
//  setContentView(R.layout.create);            
		
/* Tosignin = (Button)findViewById(R.id.button2);	
	Button home;	
    home = (Button)findViewById(R.id.button1);

    home.setOnClickListener(new OnClickListener() {

	
public void onClick(View v) {
			
			 //Intent intent = (new Intent(MainActivity.this, Signinoldaccount.class);
            //	 MainActivity(intent);
		  Intent intent = new Intent(MainActivity.this,Home.class);
          startActivity(intent);
		
		/
		
		
    });
	
	}*/
	
//}
	
    
	


	
	