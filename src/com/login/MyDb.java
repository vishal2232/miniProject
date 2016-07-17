package com.login;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.login.TableData.TableInfo;

public class MyDb extends SQLiteOpenHelper {
	// Context CTX=this;
	public static final int database_version=1;
	
	public String CREATE_QUERY= "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.USER_NAME+" TEXT,"+TableInfo.USER_EMAIL+" TEXT PRIMARY KEY,"+TableInfo.USER_PASS+" TEXT,"+TableInfo.USER_ANS+" TEXT);";


	public MyDb(Context context) {
		super(context,TableInfo.DATABASE_NAME, null, database_version);
		 Log.d("MyDb","database Created");
		          }

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Log.d("get2", "info");
		Log.d("databaseCreated", "lsakjd");
		db.execSQL(CREATE_QUERY);
		
	}  

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	public void putInfo(MyDb Db, String name, String pass,String email,String ans)
	{
		Log.d("databasePut", "rowinserted");
		SQLiteDatabase SQ= Db.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(TableInfo.USER_NAME, name);
		cv.put(TableInfo.USER_EMAIL, email);
		cv.put(TableInfo.USER_PASS, pass);
		cv.put(TableInfo.USER_ANS, ans);
		Log.d("databaseCreated", "lsakjd");
		long k=SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("database", "rowinserted");
	}
	public Cursor getInformation(MyDb db)
	{
		Log.d("Cget2", "info");
		SQLiteDatabase SQ=db.getReadableDatabase();
		Log.d("Cget3", "info");
		String[] columns={ TableInfo.USER_NAME,TableInfo.USER_EMAIL,TableInfo.USER_PASS };
		Log.d("Cget4", "info");
		Cursor CR=SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
		Log.d("Cget5", "info");
		return CR;
		
	}
	public void updateProfile(MyDb db, String user_email,String newUserName,  String newUserEmail,String newUserPass ) {
		
		SQLiteDatabase SQ=db.getWritableDatabase();
		String selection=TableInfo.USER_EMAIL+" LIKE ?";
		Log.d("Cget51", "info");
		String arg[]={user_email};
		Log.d("Cget52", "info");
		ContentValues cv=new ContentValues();
		cv.put(TableInfo.USER_NAME, newUserName);
		
		cv.put(TableInfo.USER_EMAIL, newUserEmail);
		Log.d("Cget53", "info");
		cv.put(TableInfo.USER_PASS, newUserPass);
		Log.d("Cget54", "info");
		int k=SQ.update(TableInfo.TABLE_NAME, cv, selection, arg);
		Log.d("Cget55", "info");
		
			}
	
	
public void updatePass(MyDb db, String user_email,String newUserPass ) {
		
		SQLiteDatabase SQ=db.getWritableDatabase();
		String selection=TableInfo.USER_EMAIL+" LIKE ?";
		
		String arg[]={user_email};
		
		ContentValues cv=new ContentValues();
		//cv.put(TableInfo.USER_NAME, newUserName);
		
		//cv.put(TableInfo.USER_EMAIL, newUserEmail);
		
		cv.put(TableInfo.USER_PASS, newUserPass);
		int k=SQ.update(TableInfo.TABLE_NAME, cv, selection, arg);
		
			}

public void updateAns(MyDb db, String user_email,String newAns ) {
	
	SQLiteDatabase SQ=db.getWritableDatabase();
	String selection=TableInfo.USER_EMAIL+" LIKE ?";
	
	String arg[]={user_email};
	
	ContentValues cv=new ContentValues();
	//cv.put(TableInfo.USER_NAME, newUserName);
	
	//cv.put(TableInfo.USER_EMAIL, newUserEmail);
	
	cv.put(TableInfo.USER_ANS, newAns);
	int k=SQ.update(TableInfo.TABLE_NAME, cv, selection, arg);
	
		}
	//Search Email
public  boolean searchContact(MyDb db,String email)
{
	boolean found=false;
	Cursor CR=db.getInformation(db);
	CR.moveToFirst();
	
	
	Log.d("search3", "info");
	do{
		
		Log.d("search4", "info");
		if(email.equals(CR.getString(1)))
		{
			Log.d("search5", "info");
			found=true;
		
			 break;
		}
		
		
	}while(CR.moveToNext());
	
	return found;
	}
//Search Security Answer using Email
public  boolean searchAns(MyDb db,String email, String ans)
{
	Cursor CR=db.getInformation(db);
	CR.moveToFirst();
	
	boolean found=false;
	Log.d("search3", "info");
	do{
		
		Log.d("search4", "info");
		if(email.equals(CR.getString(1)) && ans.equals(CR.getString(3)) )
		{
			found=true;
		
			 break;
		}
		
		
	}while(CR.moveToNext());
	
	return found;
	}


	public void deleteProfile()
	{
		
	}

}
