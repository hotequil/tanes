package com.tanes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, dbName: String) : SQLiteOpenHelper(context, dbName, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE users (id INT NOT NULL, name VARCHAR(100) NOT NULL, pronoun VARCHAR(10) NOT NULL, PRIMARY KEY (id))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insertUser(id: Int, name: String, pronoun: String){
        val contentValues = ContentValues()

        contentValues.put("id", id)
        contentValues.put("name", name)
        contentValues.put("pronoun", pronoun)

        this.writableDatabase.insert("users", null, contentValues)
    }

    fun listUsers(): Cursor{
        return this.readableDatabase.rawQuery("SELECT name, pronoun FROM users", null)
    }

    fun deleteUser(){
        this.writableDatabase.delete("users", "id=1", null)
    }
}
