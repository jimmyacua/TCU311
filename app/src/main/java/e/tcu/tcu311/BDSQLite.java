package e.tcu.tcu311;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSQLite extends SQLiteOpenHelper {

    private String sql = "create table eventos (" +
            "idEvento int identity, " +
            "nombreEvento varchar(50), " +
            "descripcion varchar(100), " +
            "fechaDesde date, " +
            "horaDesde time)";

    private String tablaEventosFijos = "create table eventosFijos (" +
            "numEvento int identity, " +
            "nombreEvento varchar(50), " +
            "descripcion varchar(100), " +
            "fechaDesde date)";

    private String insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
            "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
            ", residuos de frutas y vegetales','14 - 1 - 2019')";

    public BDSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaEventosFijos);
        db.execSQL(insertEventosFijos);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
