package demo.example.com.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    Context context;


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT" +
                ",SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String surname, String marks) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "DATA NO SAVED", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, "DATA SAVED", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
            return true;
        }

    }

    public int updateData(String name, String surname, String marks) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        String whereClause = "id=?";
        String whereArgs[] = {name.toString(), surname.toString(), marks.toString()};
        int result = sqLiteDatabase.update(TABLE_NAME, contentValues, whereClause, whereArgs);

        if (result != 0) {
            /*Toast.makeText(this,"update successful",Toast.LENGTH_LONG).show();*/
            return result;
        } else {
            /*Toast.makeText(this,"data is not updated",Toast.LENGTH_SHORT).show();*/
            return 0;
        }

    }
    /* public void deleteData(Context context*//*String name,String surname,String marks*//*) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "id=?";
        String whereArgs[] = {context.id.toString()};
        db.delete(TABLE_NAME, whereClause, whereArgs);
    }*/
   /*public void retrieve(String name, String surname, String marks) {
       SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursor = db.query(TABLE_NAME, new String[] { , null, null, null, null);
       if (cursor != null)
           cursor.moveToFirst();

       // return contact
       return ;
   }
*/
}

