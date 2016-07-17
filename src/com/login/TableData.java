package com.login;

import android.provider.BaseColumns;

public class TableData {
		public TableData()
					{
			
					}
	
		public static abstract class TableInfo implements BaseColumns{
		public static final String USER_NAME="user_name";
		public static final String USER_EMAIL="user_email";
		public static final String USER_PASS="user_pass";
		public static final String USER_ANS="user_ans";
		public static final String DATABASE_NAME="demo_version6.db";
		public static final String TABLE_NAME="demotable";
	}

}
