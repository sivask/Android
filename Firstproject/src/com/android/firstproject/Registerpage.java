package com.android.firstproject;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Registerpage extends Activity{
	
	Button Registerpage;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regpage);
        
        Button Registerpage = (Button) findViewById(R.id.btnreg);
    	Registerpage.setOnClickListener(new OnClickListener() {


     public void onClick(View v) {
    	 
       	  Intent intent = new Intent(Registerpage.this,Registerform.class); 
        	startActivity(intent);
       	  
        
     }
        });
          
    }
    

        
	}

