package com.example.servicioprovider.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(
    context: Context
): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "dbusuarios"
        const val DATABASE_VERSION = 1
        const val TABLE_USUARIOS_NAME = "usuarios"
        val COLUMS_TABLEUSUARIOS = arrayOf(
            "_id",
            "nombre", "email", "password", "tel"
        )
        private const val SCRIPT_TABLE_USUARIOS = "create table usuarios (" +
                "_id integer primary key autoincrement, " +
                "nombre text, " +
                "email text not null, " +
                "password text not null, " +
                "tel text not null); "
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SCRIPT_TABLE_USUARIOS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}