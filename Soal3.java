package ivancorp.menuslidenavigation;

/**
 * Created by USER on 19/07/2017.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Soal3 extends SQLiteOpenHelper {
    final static String DB_NAME = "db_kuis13";

    public Soal3(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        values.put("soal", "Bahasa pemrograman yang dikembangkan oleh Sun Microsystem adalah ...");
        values.put("pil_a", "Javascript");
        values.put("pil_b", "Java");
        values.put("pil_c", "C++");
        values.put("jwban","1");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Client Scripting yang dikeluarkan oleh Microsoft adalah ...");
        values.put("pil_a", "VBScript ");
        values.put("pil_b","JScript");
        values.put("pil_c", "JavaScript");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Yang bukan fungsi dari JavaScript adalah ...");
        values.put("pil_a", "Detect Browser");
        values.put("pil_b", "Create Cookies");
        values.put("pil_c", "Synchronization");
        values.put("jwban","2");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Berikut ini yang bukan tipe data primitive dari JavaScript adalah ...");
        values.put("pil_a", "Boolean");
        values.put("pil_b", "Number");
        values.put("pil_c", "Float");
        values.put("jwban","2");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Operator yang berfungsi untuk modulus adalah ... ");
        values.put("pil_a", "%");
        values.put("pil_b","+");
        values.put("pil_c", "*");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

    }

    public List<Soal> getSoal(){
        List<Soal> listSoal = new ArrayList<Soal>();
        String query = "select * from tbl_soal";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Soal s = new Soal();
                s.setSoal(cursor.getString(1));
                s.setPil_a(cursor.getString(2));
                s.setPil_b(cursor.getString(3));
                s.setPil_c(cursor.getString(4));
                s.setJwban(cursor.getInt(5));
                listSoal.add(s);
            }while(cursor.moveToNext());
        }

        return listSoal;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_soal");
        onCreate(db);
    }

}