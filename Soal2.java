package ivancorp.menuslidenavigation;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Soal2 extends SQLiteOpenHelper {
    final static String DB_NAME = "db_kuis11";

    public Soal2(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        values.put("soal", "Kepanjangan dari PHP adalah ...");
        values.put("pil_a", "Protocol Hypertext Podcast");
        values.put("pil_b", "Preprocecor Hyper Protocol");
        values.put("pil_c", "PHP : Hypertext Preprocecor");
        values.put("jwban","2");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "File Extensi PHP adalah ...");
        values.put("pil_a", "docx");
        values.put("pil_b", "php");
        values.put("pil_c", "html");
        values.put("jwban","1");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Tipe data yang berisikan dua nilai adalah ...");
        values.put("pil_a", "Boolean");
        values.put("pil_b", "Integer");
        values.put("pil_c", "String");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Berikut ini yang bukan tipe data pada PHP...");
        values.put("pil_a", "Integer");
        values.put("pil_b", "String");
        values.put("pil_c", "Primary Key");
        values.put("jwban","2");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", " Berikut ini yang bukan Tools Text Editor untuk PHP adalah ... ");
        values.put("pil_a", "Notepad");
        values.put("pil_b", "Sublime Text");
        values.put("pil_c", "Paint");
        values.put("jwban","2");
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