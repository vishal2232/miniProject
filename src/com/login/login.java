package com.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {
	
	 EditText user;
	 EditText pass;
	 Button login;
	 Button signup;
	 Button cancel;
	 Context CTX=this;
	 TextView result,t4;
	 String NAME="";
	 String PASS,EMAIL="";
	 String email,password;
	 int count=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    user=(EditText)findViewById(R.id.et1);
    pass=(EditText)findViewById(R.id.et2);
    login=(Button)findViewById(R.id.b1);
    cancel=(Button)findViewById(R.id.b2);
    result=(TextView)findViewById(R.id.t3);
   t4=(TextView)findViewById(R.id.tv4);
  signup=(Button)findViewById(R.id.b3);
 
    login.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			MyDb db=new MyDb(CTX);
			 email=user.getText().toString();
			password=pass.getText().toString();
			
			 
			Cursor CR=db.getInformation(db);
			CR.moveToFirst();
			
			boolean loginstatus=false;
			Log.d("login3", "info");
			do{
				
				Log.d("login4", "info");
				if(email.equals(CR.getString(1))&&(password.equals(CR.getString(2))))
				{
					Log.d("login5", "info");
					loginstatus=true;
					 NAME=CR.getString(0);
					EMAIL=CR.getString(1);
					PASS=CR.getString(2);
					 Toast.makeText(login.this, "Please Wait... "+NAME ,Toast.LENGTH_LONG).show();
					email="";
					password="";
					 break;
				}
				
				
			}while(CR.moveToNext());
			
			if(loginstatus)
			{
				 Toast.makeText(login.this, "Logged in...Successfully" ,Toast.LENGTH_LONG).show();
				 user.setText("");
				 pass.setText("");
				Intent i=new Intent(login.this, xyz.class);
				i.putExtra("uname",NAME);
				i.putExtra("uemail",EMAIL);
				i.putExtra("upass",PASS);
				startActivity(i);
			}
			else{
				count++;
				 Toast.makeText(login.this, "Login Failed..." ,Toast.LENGTH_LONG).show();
				if(count==3)
				 finish();
				}
		}
	});
    
    t4.setOnClickListener(new OnClickListener() {
    	
    	public void onClick(View arg0) {
    		forgotPassword();
       	}
    });
    
    
    signup.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
		
			Intent i=new Intent(login.this, Signup.class);
			
			startActivity(i);
		}
	});
    
    
cancel.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
		
    if((v.getId()==(R.id.b2))){
		finish();
	}
		}	});
}
    public void forgotPassword()
    {
    	Intent i=new Intent(login.this,ForgotPass.class);
    	startActivity(i);
    }
}