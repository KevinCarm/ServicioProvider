package com.example.servicioprovider.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DAOUsuario(
    private val context: Context, private val db: DB = DB(context),
    private var ad: SQLiteDatabase = db.writableDatabase
) {
    fun insert(cv: ContentValues): Long {
        return ad.insert(DB.TABLE_USUARIOS_NAME, null, cv)
    }

    fun getAllCursor(): Cursor? {
        val cursor: Cursor? =
            ad.query(
                DB.TABLE_USUARIOS_NAME, DB.COLUMS_TABLEUSUARIOS,
                null, null, null, null, null
            )
        return cursor
    }

    fun update(values: ContentValues, s: String, strings: Array<out String>?): Int {
        return ad.update(DB.TABLE_USUARIOS_NAME, values, s, strings)
    }

    fun delete(s: String, strings: Array<out String>?): Int {
        return ad.delete(DB.TABLE_USUARIOS_NAME, s, strings)
    }
}