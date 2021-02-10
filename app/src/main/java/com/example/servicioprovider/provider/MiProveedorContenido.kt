package com.example.servicioprovider.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.servicioprovider.data.DAOUsuario

class MiProveedorContenido : ContentProvider() {

    private lateinit var daoUsuario: DAOUsuario
    private val uriMath: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        .apply {
            addURI("com.example.servicioprovider.provider", "usuarios", 1)
            addURI("com.example.servicioprovider.provider", "usuarios/#", 2)
            addURI("com.example.servicioprovider.provider", "usuarios/*", 3)
        }

    override fun onCreate(): Boolean {
        context?.let {
            daoUsuario = DAOUsuario(it)
        }
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        var result: Cursor? = null
        when (uriMath.match(uri)) {
            1 -> {
                result = daoUsuario.getAllCursor()
            }
        }
        return result
    }

    override fun getType(uri: Uri): String? {
        var result = ""
        when (uriMath.match(uri)) {
            1 -> {
                result =
                    "vnd.android.cursor.dir/vnd.com.example.servicioprovider.provider.usuarios"
            }
            2 -> {
                result =
                    "vnd.android.cursor.item/vnd.com.example.servicioprovider.provider.usuarios"
            }
            3 -> {
                result =
                    "vnd.android.cursor.dir/vnd.com.example.servicioprovider.provider.usuarios"

            }
        }
        return result
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        var result: Uri? = null
        when (uriMath.match(uri)) {
            1 -> {
                val idNewRow = values?.let {
                    daoUsuario.insert(it)
                }
                result = Uri.withAppendedPath(uri, idNewRow.toString())
            }
        }
        return result
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        var result = 0
        when (uriMath.match(uri)) {
            1 -> {
                result =
                    daoUsuario.delete(selection!!, selectionArgs)
            }
            2 -> {
                result =
                    daoUsuario.delete(selection!!, selectionArgs)
            }
            3 -> {
                result =
                    daoUsuario.delete(selection!!, selectionArgs)
            }
        }
        return result
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        var result = 0
        when (uriMath.match(uri)) {
            1 -> {
                result =
                    daoUsuario.update(values!!, selection!!, selectionArgs)
            }
            2 -> {
                result =
                    daoUsuario.update(values!!, selection!!, selectionArgs)
            }
        }
        return result
    }
}