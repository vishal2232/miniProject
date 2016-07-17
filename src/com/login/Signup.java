package com.login;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class Signup extends Activity {
	EditText name;
	EditText email;
	EditText passwd;
	EditText cnfrmpasswd;
	Button signup,back;
	Context ctx=this;
	boolean status=true;
	String  strans="sad";;
	String strname,strpasswd,strcpasswd,stremail;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        name=(EditText)findViewById(R.id.et1);
        email=(EditText)findViewById(R.id.et2);
        passwd=(EditText)findViewById(R.id.et3);
        cnfrmpasswd=(EditText)findViewById(R.id.et4);
        signup=(Button)findViewById(R.id.b1);
        back=(Button)findViewById(R.id.b2);
        
        
        signup.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				MyDb db=new MyDb(ctx);
			strname=name.getText().toString();
			stremail=email.getText().toString();
			strpasswd=passwd.getText().toString();
			strcpasswd=cnfrmpasswd.getText().toString();
			
			
			
			 if(!isValidEmail(stremail))
			{
				
				Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
				email.setText(""); 
				
			}
			
			 else	if (strpasswd.length() < 5 || strname.equals("") )
			{
				
				Toast.makeText(getBaseContext(), "Complete Your Form first..\n Password is too Short ", Toast.LENGTH_LONG).show();

			}
			
			else if(!(strpasswd.equals(strcpasswd)) )
				{
				
					Toast.makeText(getApplicationContext(), "Password Not Matching", Toast.LENGTH_LONG).show();
					//name.setText(""); 
					
					passwd.setText(""); 
					cnfrmpasswd.setText("");
					
				}
			 
			 else if((db.searchContact(db, stremail)))
				{
				
					Toast.makeText(getApplicationContext(), "Email Already Registred", Toast.LENGTH_LONG).show();
					email.setText(""); 
				}
			
			 else {
					
					//MyDb db=new MyDb(ctx);
				
					
					db.putInfo(db, strname,strpasswd,stremail,strans);
					Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Signup.this,SecurityQuestion.class);
					intent.putExtra("uname", strname);
				intent.putExtra("uemail", stremail);
					startActivity(intent);
					//finish();
					Log.d("put3", "info");
				}
							
			}
		}); 
        back.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				finish();
				
			}
		});
            
	}
	// validating email 
	public boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}