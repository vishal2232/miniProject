package com.login;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class xyz extends Activity{
	TextView t2,t3;
	Button update,relogin;
	String User,Email,Pass;
	//public   String name,Email;
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.anothermain);
	    Bundle b=getIntent().getExtras();
	     User=b.getString("uname");
	    Email=b.getString("uemail");
	    Pass=b.getString("upass");
	       //   TextView score=(TextView)findViewById(R.id.textView1);
		 relogin=(Button)findViewById(R.id.button1);
		   // score.setText("Welcome  \n\nYou are successfully logged in");
	      
			//t1=(TextView)findViewById(R.id.tv1);
			t2=(TextView)findViewById(R.id.tv2);
			t3=(TextView)findViewById(R.id.tv3);
			 relogin.setOnClickListener(new OnClickListener() {
					
					public void onClick(View arg0) {
						Intent intent=new Intent(xyz.this,login.class);
						startActivity(intent);
						
					}
				});
			//t1.setText("")
			//Intent i=getIntent();
		//User =i.getStringExtra("uname");
		// Email =i.getStringExtra("uemail");
			t2.setText(User);
			//t2.setText("user");
			t3.setText(Email);
			
			update=(Button)findViewById(R.id.b2);
			update.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					Intent i=new Intent(getApplicationContext(),ReEnterPass.class);
					i.putExtra("uname", User);
					i.putExtra("uemail", Email);
					i.putExtra("upass", Pass);
					startActivity(i);
					
				}
			});
			
			
	        
		}
	        
	}    
/* 
	        // Intent myintent=getIntent();
	      //  String username=myintent.getStringExtra("name");
	      //  TextView score=(TextView)findViewById(R.id.textView1);
	      //  Button relogin=(Button)findViewById(R.id.button1);
	      //  score.setText("Welcome "+username+" \n\nYou are successfully logged in");
	      
	    t1=(TextView)findViewById(R.id.textView1);
			MyDb mydb=new MyDb(xyz.this);
			SQLiteDatabase database= mydb.getReadableDatabase();
			Cursor cursor= database.rawQuery("Select * from demotable", null);
		String s="";
			if(cursor.moveToFirst())
			{
				do{
									
					String name=cursor.getString(cursor.getColumnIndex("name"));
					String email=cursor.getString(cursor.getColumnIndex("email"));
					//String passwd=cursor.getString(cursor.getColumnIndex("passwd"));
					
					s=s+"F Name="+name+"\tL name="+email+"\n";
					t1.setText("F name="+name+"\t L name=+"+email+"\n");
				}while(cursor.moveToNext());
			}
			cursor.close();
			database.close();
	        
	        
	        
	        */

