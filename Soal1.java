package ivancorp.menuslidenavigation;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Soal1 extends SQLiteOpenHelper {
    final static String DB_NAME = "db_kuis12";

    public Soal1(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        values.put("soal", "Definisi dari Mark Up adalah ...");
        values.put("pil_a", "Informasi tambahan yang di tempatkan pada text untuk diinterpretasikan");
        values.put("pil_b","Suatu text yang didalamnya ada sebuah data");
        values.put("pil_c", "Text yang digunakan untuk menghasilkan informasi");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "XML merupakan kepanjangan dari ...");
        values.put("pil_a", "Extensible Markup Language");
        values.put("pil_b","Extend Markup Language");
        values.put("pil_c", "External Markup Language");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Perintah untuk melakukan break pada HTML adalah ... ");
        values.put("pil_a", "Ln");
        values.put("pil_b","Break");
        values.put("pil_c", "Br");
        values.put("jwban","2");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Atribut HTML adalah ... ");
        values.put("pil_a", "Informasi tambahan yang diberikan kepada tag");
        values.put("pil_b", "Informasi yang berupa text untuk seluruh element HTML");
        values.put("pil_c", "tampilan dari HTML yang memudahkan pengguna");
        values.put("jwban","0");
        db.insert("tbl_soal", "soal", values);

        values.put("soal", "Yang Merupakan Visual Editor untuk Pembuatan Web adalah ... ");
        values.put("pil_a", "Adobe Dreamweaver");
        values.put("pil_b", "Adobe Photoshop");
        values.put("pil_c", "Macromedia Flash");
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