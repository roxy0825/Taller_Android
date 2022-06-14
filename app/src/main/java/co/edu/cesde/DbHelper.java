package co.edu.cesde;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 20;
    public static final String DATABASE_NAME = "cesdeshop";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VRCHAR(50), email VRCHAR(50),"+
                "identification int, password VRCHAR(16)) ");

        sqLiteDatabase.execSQL(
                "CREATE TABLE productos (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nomProducto VRCHAR(50),cod VRCHAR(16), descrip VRCHAR(50), fabricante VRCHAR(16)," +
                        "preUni VRCHAR(16), categoria VRCHAR(16))");

    }
    //int i, int i1)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos ");
        onCreate(sqLiteDatabase);

    }

}
