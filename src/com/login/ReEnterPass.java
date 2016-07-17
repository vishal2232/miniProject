package com.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class ReEnterPass extends Activity {
EditText password;
Button submit,cancel;
String User,Email,strPass,passwd;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.re_enter_pass);
	password=(EditText)findViewById(R.id.et1);
	cancel=(Button)findViewById(R.id.b2);
  submit=(Button)findViewById(R.id.b1);
  
  Bundle b=getIntent().getExtras();
  User=b.getString("uname");
 Email=b.getString("uemail");
 strPass=b.getString("upass");
  
  submit.setOnClickListener(new OnClickListener() {
	
	public void onClick(View arg0) {
		passwd=password.getText().toString();
		
		if(strPass.equals(passwd))
		{
			password.setText("");
			Toast.makeText(getApplicationContext(), "Please wait...", Toast.LENGTH_SHORT).show();
			Intent i=new Intent(ReEnterPass.this,ProfileUpdate.class);
			i.putExtra("uname", User);
			i.putExtra("uemail", Email);
			i.putExtra("upass", strPass);
			startActivity(i);
		}
		else{
			
			Toast.makeText(getApplicationContext(), "Sorry Wrong Password", Toast.LENGTH_LONG).show();
			password.setText("");
		}
	}
});
  cancel.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			finish();
			
		}
	});
  
	
  }

}
