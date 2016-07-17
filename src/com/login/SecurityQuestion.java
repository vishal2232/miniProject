package com.login;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecurityQuestion extends Activity{
	TextView t1;
	EditText e1;
	Button submit,skip;
	String uname,uemail,newAns="dalk@";
	Spinner spinner;
	Context context=this;
	MyDb db=new MyDb(context);
	    ArrayAdapter<CharSequence>adapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.security_question);
	t1=(TextView)findViewById(R.id.textView_user);
	spinner=(Spinner)findViewById(R.id.spinner1);
    adapter=ArrayAdapter.createFromResource(SecurityQuestion.this,R.array.planets_array,android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
spinner.setAdapter(adapter)   ;
	Intent i=getIntent();
	 uname=i.getStringExtra("uname");
	uemail=i.getStringExtra("uemail");
	t1.setText(uname);
	e1=(EditText)findViewById(R.id.et1);
	submit=(Button)findViewById(R.id.b1);
	skip=(Button)findViewById(R.id.b2);

	submit.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			newAns=e1.getText().toString();
			if(newAns.equals("dalk@")|| newAns.equals("")){
				Toast.makeText(getApplicationContext(), "Enter Security Answer", Toast.LENGTH_LONG).show();
			}
			else{
				
				db.updateAns(db, uemail, newAns);
				Toast.makeText(getApplicationContext(), "Security Answer updated", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(SecurityQuestion.this,login.class);
				startActivity(intent);
				//finish();
			}
			
			
		}
	});
	
	skip.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			//MyDb db=new MyDb(context);
			Intent intent=new Intent(SecurityQuestion.this,login.class);
			startActivity(intent);
		}
	});
}
}
