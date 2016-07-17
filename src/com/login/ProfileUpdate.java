package com.login;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileUpdate extends Activity{
Button update,cancel;
String Uname,Uemail,Upass, newUserName,newUserPass, newUserEmail,newUserCPass;
EditText userName,userEmail,userPass,userCPass;
Context CTX=this;
boolean status=true;
MyDb db=new MyDb(CTX);
Signup signup =new Signup();
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.profile_update);
		update=(Button)findViewById(R.id.b1);
		cancel=(Button)findViewById(R.id.b2);
		Intent i=getIntent();
		Uname=i.getStringExtra("uname");
		Uemail=i.getStringExtra("uemail");
		Upass=i.getStringExtra("upass");
		userName=(EditText)findViewById(R.id.et1);
		userEmail=(EditText)findViewById(R.id.et2);
		userPass=(EditText)findViewById(R.id.et3);
		userCPass=(EditText)findViewById(R.id.et4);
		
		userName.setText(Uname);
		userEmail.setText(Uemail);
		userPass.setText(Upass);
		
   update.setOnClickListener(new OnClickListener() {
		
		    public void onClick(View arg0) {
			newUserName=userName.getText().toString();
			newUserEmail=userEmail.getText().toString();
			newUserPass=userPass.getText().toString();
			
			newUserCPass=userCPass.getText().toString();
		
						
			if (newUserPass.length() <5 || newUserName.equals("") )
			{
				
				Log.d("userPass.equals","");
				status=false;
				Toast.makeText(getBaseContext(), "Complete Your Form first..\n Password is too Short ", Toast.LENGTH_LONG).show();

			}
			
			else	 if(!newUserPass.equals(newUserCPass)) 
				{
				 Log.d("newUserPass.equals","");
				status=false;
					Toast.makeText(getApplicationContext(), "Password Not Matching", Toast.LENGTH_LONG).show();
					//name.setText(""); 
					
					userPass.setText(""); 
					userCPass.setText("");
					
				}
			 else	 if(!(signup.isValidEmail(newUserEmail)))
				{
				 Log.d("isValidEmail","");
				status=false;
					Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
					userEmail.setText(""); 
				}
				
			 else	if((db.searchContact(db, newUserEmail)))
			{
					Log.d("searchContact","");
				
				Toast.makeText(getApplicationContext(), "Email Already Registred..\nChoose another", Toast.LENGTH_LONG).show();
				userEmail.setText(""); 
			}
				else
			{
				
				Log.d("status","true");
			//db=new MyDb(CTX);
			db.updateProfile(db,Uemail, newUserName,newUserEmail,newUserPass);
			Toast.makeText(getBaseContext(), "Profile Updated", Toast.LENGTH_LONG).show();
			userName.setText("");
			userEmail.setText("");
			userPass.setText("");
			Toast.makeText(getBaseContext(), "Relogin", Toast.LENGTH_SHORT).show();
			Intent i=new Intent(getBaseContext(),login.class);
			startActivity(i);
			}
		    }
	});
   cancel.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			Intent i=new Intent(ProfileUpdate.this,xyz.class);
			startActivity(i);
			
		}
	});
   
}
}