package com.exam.internal_practical_test

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        private var DB_NAME = "FruitMarket"
        private var TB_NAME = "Fruit"
        private var DB_VERSION = 1
        private var FR_ID = "id"
        private var FR_NAME = "Fr_name"
        private var FR_DES = "Fr_des"
        private var FR_PRICE = "Fr_price"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "Create Table $TB_NAME($FR_ID INTEGER PRIMARY KEY AUTOINCREMENT, $FR_NAME TEXT, $FR_PRICE INTEGER, $FR_DES TEXT)"
        p0?.execSQL(query);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
       var query = "Drop Table $TB_NAME If Exists"
        p0?.execSQL(query);
    }

    fun Insert(fruit:fruit):Boolean{
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(FR_NAME, fruit.Fr_name)
        cv.put(FR_DES, fruit.Fr_des)
        cv.put(FR_PRICE, fruit.Fr_price)
        var flag =db.insert(TB_NAME,null,cv)
        return flag>0
    }
    fun retriveAll():ArrayList<fruit>
    {
        var arr=ArrayList<fruit>()
        var db=readableDatabase
        var cursor=db.query(TB_NAME,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {


            var name=cursor.getString(1)
            var des=cursor.getString(3)
            var price=cursor.getInt(2)
            var p=fruit(name,des,price)
            arr.add(p)
        }
        return arr

    }
}