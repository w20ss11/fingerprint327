package com.chongyou.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WifiInfoSQLiteOpenHelper extends SQLiteOpenHelper {

	//���ݰ�����  ���ڴ����͹������ݿ�
	public WifiInfoSQLiteOpenHelper(Context context) {
		super(context, "wifiInfo.db", null, 1);
		// TODO �Զ����ɵĹ��캯�����
	}
//���ݴ���ʱ�ص��˷��� ��ʼ��һЩ��
	@Override
	public void onCreate(SQLiteDatabase db) {
		//db������Բ������ݿ�
		String sql="create table wifiInfo(_id integer primary key,wifiName varchar(20),wifiStrength integer,MacAddress varchar(20));";
		db.execSQL(sql);
	}
//���ݿ�汾�Ÿ���ʱ�ص��˷��� �������ݿ�����ݣ�ɾ���� ��ӱ� �޸ı�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
