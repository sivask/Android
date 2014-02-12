package com.android.firstproject;

	import java.util.ArrayList;
import java.util.List;

	import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

	import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


	public class Registerform  extends Activity implements OnClickListener {
		private EditText user, pass,confirmpass,company_name,description,contact_no;
		private Button Register;
		
	        
		
		 // Progress Dialog
	    private ProgressDialog pDialog;
	 
	    // JSON parser class
	    JSONParser jsonParser = new JSONParser();
	    
	    //php login script
	    
	    //localhost :  
	    //testing on your device
	    //put your local ip instead,  on windows, run CMD > ipconfig
	    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
	   // private static final String LOGIN_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";
	    
	    //testing on Emulator:
	    private static final String LOGIN_URL = "http://arunimmanuel.000space.com/Social/signup.php";
	    
	  //testing from a real server:
	    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/register.php";
	    
	    //ids
	    private static final String TAG_SUCCESS = "success";
	    private static final String TAG_MESSAGE = "message";
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.registerpage);
			
			 user = (EditText)findViewById(R.id.username);
			 pass = (EditText)findViewById(R.id.password);
			 confirmpass = (EditText)findViewById(R.id.c_pass);
			company_name = (EditText)findViewById(R.id.c_name);
			description = (EditText)findViewById(R.id.descrip);
			contact_no = (EditText)findViewById(R.id.contact);
			
			
			

			Register = (Button)findViewById(R.id.register);
			Register.setOnClickListener(this);
			
		}


		public void onClick(View v) {
			// TODO Auto-generated method stub
			
					new CreateUser().execute();
			
		}
		
		class CreateUser extends AsyncTask<String, String, String> {

			 /**
	         * Before starting background thread Show Progress Dialog
	         * */
			boolean failure = false;
			
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            pDialog = new ProgressDialog(Registerform.this);
	            pDialog.setMessage("Creating User...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }
			
			@Override
			protected String doInBackground(String... args) {
				// TODO Auto-generated method stub
				 // Check for success tag
	            int success;
	          //user = (EditText)findViewById(R.id.username);
	            String username = user.getText().toString();
	            String password = pass.getText().toString();
	       	    String c_pass = confirmpass.getText().toString();
	            String c_name = company_name.getText().toString();
	            String descrip = description.getText().toString();
	            String contact = contact_no.getText().toString();
	            try {
	                // Building Parameters
	                List<NameValuePair> params = new ArrayList<NameValuePair>();
	                params.add(new BasicNameValuePair("txtUname", username));
	                params.add(new BasicNameValuePair("txtPass", password));
	                params.add(new BasicNameValuePair("txtconfirmpass",c_pass));
	                params.add(new BasicNameValuePair("txtcompany_name",c_name));
	                params.add(new BasicNameValuePair("txtdescription",descrip));
	                params.add(new BasicNameValuePair("txtcontact_no",contact));
	 
	                Log.d("request!", "starting");
	                
	                //Posting user data to script 
	                JSONObject json = jsonParser.makeHttpRequest(
	                       LOGIN_URL, "POST", params);
	 
	                // full json response
	                Log.d("Login attempt", json.toString());
	 
	                // json success element
	                success = json.getInt(TAG_SUCCESS);
	                if (success == 1) {
	                	Log.d("User Created!", json.toString());              	
	                	finish();
	                	return json.getString(TAG_MESSAGE);
	                }else{
	                	Log.d("Login Failure!", json.getString(TAG_MESSAGE));
	                	return json.getString(TAG_MESSAGE);
	                	
	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	 
	            return null;
				
			}
			/**
	         * After completing background task Dismiss the progress dialog
	         * **/
	        protected void onPostExecute(String file_url) {
	            // dismiss the dialog once product deleted
	            pDialog.dismiss();
	            if (file_url != null){
	            	Toast.makeText(Registerform.this, file_url, Toast.LENGTH_LONG).show();
	            }
	 
	        }
			
		}
			 

	}
	
	

