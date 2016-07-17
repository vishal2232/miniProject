package com.login;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ForgotSecurityAns extends Activity{
Button b1,b2,b3;
EditText e1;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.forgot_security_ans);
	b1=(Button)findViewById(R.id.b1);
	b2=(Button)findViewById(R.id.b2);
	b3=(Button)findViewById(R.id.b3);
	e1=(EditText)findViewById(R.id.et1);
	b1.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			String ans=e1.getText().toString();
			
		}
	});
	
b2.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			finish();
			
		}
	});

b3.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			Intent i=new Intent(ForgotSecurityAns.this,login.class);
			startActivity(i);
			
		}
	});
	
}

}
