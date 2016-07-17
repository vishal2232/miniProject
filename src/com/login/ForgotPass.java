package com.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPass extends Activity {
	Button reset,secans;
	Context CTX=this;
	boolean found=false;
	EditText email;
	String stremail,EMAIL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_pass);
		reset=(Button)findViewById(R.id.b1);
		secans=(Button)findViewById(R.id.b2);
		email=(EditText)findViewById(R.id.et1);
		
		reset.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				 stremail=email.getText().toString();
					
					
					MyDb db=new MyDb(CTX);
					Cursor CR=db.getInformation(db);
					CR.moveToFirst();
					
					
					
					do{
						
						Log.d("forgot4", "info");
						if(stremail.equals(CR.getString(1)))
						{
							found=true;
						EMAIL=CR.getString(1);
							/* NAME=CR.getString(0);
							PASS=CR.getString(2);
							*/
							 Toast.makeText(getBaseContext(), "Please Wait... ",Toast.LENGTH_LONG).show();
							email.setText("");
							
							 break;
						}
						
						
					}while(CR.moveToNext());
					if(found)
					{
						int num=random_int(100001, 999999);
						
						String s=Integer.toString(num);
						sendEmail(s,EMAIL);
						db.updatePass(db,EMAIL,s);
						
						
						/*
						
						Intent i=new Intent(login.this, xyz.class);
						i.putExtra("uname",NAME);
						i.putExtra("uemail",EMAIL);
						i.putExtra("upass",PASS);
						startActivity(i);
						*/
					}
					else{
						 Toast.makeText(getBaseContext(), "Email Not Registered..." ,Toast.LENGTH_LONG).show();
						//finish();
						}
				}
				
				
				
				
			
		});
		secans.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i=new Intent(ForgotPass.this,ForgotSecurityAns.class);
				startActivity(i);
			}
		});
		
	}
	
	public static int random_int(int Min, int Max)
	{
	     return (int) (Math.random()*(Max-Min))+Min;
	}
	
	
	public void sendEmail(String num,String mail) {
	   //  Log.i("Send email", "");

	 char[]   TO = mail.toCharArray() ;
	    //  String[] CC = {"mcmohd@gmail.com"};
	      Intent emailIntent = new Intent(Intent.ACTION_SEND);
	      emailIntent.setData(Uri.parse("mailto:"+mail));
	      emailIntent.setType("text/plain");


	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	      //emailIntent.putExtra(Intent.EXTRA_CC, CC);
	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reset Password");
	      emailIntent.putExtra(Intent.EXTRA_TEXT, num);

	      try {
	         //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	    	  Toast.makeText(getBaseContext(), 
	    		         "Finished sending email...", Toast.LENGTH_SHORT).show();
	         finish();
	         Log.i("Finished sending email...", "");
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(getBaseContext(), 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
	      }
	   }

}
