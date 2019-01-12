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
            "descripcion varchar(300), " +
            "fechaDesde date)";


    public BDSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaEventosFijos);
        //db.execSQL(insertEventosFijos);
        agregarEventosFijos(db);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void agregarEventosFijos(SQLiteDatabase db){
     //EVENTOS DE LUNES, MARTES Y MIERCOLES:
        //ENERO:
        int lunes = 14;
        int martes = lunes+1;
        int miercoles = martes+1;
        String insertEventosFijos = "";
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 1 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 1 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 1 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //FEBRERO:
        lunes = 4;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 28 && martes <= 28 && miercoles <= 28) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 2 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 2 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 2 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //MARZO:
        lunes = 4;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 3 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 3 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 3 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //ABRIL
        lunes = 1;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 30 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 4 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 4 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 4 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        
        //MAYO:
        lunes = 6;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 5 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 5 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 5 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        
        //JUNIO:
        lunes = 3;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 30 && martes <= 30 && miercoles <=30) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 6 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 6 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 6 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        
        //JULIO:
        lunes = 1;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 7 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 7 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 7 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        
        //AGOSTO:
        lunes = 5;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 8 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 8 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 8 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //SETIEMBRE:
        lunes = 2;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 30 && martes <= 30 && miercoles <= 30) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 9 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 9 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 9 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //OCTUBRE:
        lunes = 7;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 10 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 10 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 10 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //NOVIEMBRE:
        lunes = 4;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 30 && martes <= 30 && miercoles <= 30) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 11 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 11 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 11 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }
        //DICIEMBRE:
        lunes = 2;
        martes = lunes+1;
        miercoles = martes+1;
        while (lunes <= 31 && martes <= 31 && miercoles <= 31) {
            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Orgánicos','Tales como: cáscaras, residuos de jardín" +
                    ", residuos de frutas y vegetales','" + lunes + " - 12 - 2019')";
            lunes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Ordinarios','Tales como: restos de carne, comidas, pañales, toallas sanitarias" +
                    ", papel higíenico, envolturas de embutidos, papel sucio o con grasa, ropa, zapatos, estereofón','" + martes + " - 12 - 2019')";
            martes += 7;
            db.execSQL(insertEventosFijos);

            insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                    "('Residuos Reciclables','Tales como: bolsas, galones, pichingas, cajas de plástico" +
                    ", vidrio(no depositar vidrio de ventanas o bombillos), papel, cartón, tetrabrik, " +
                    "tetrapack* y latas* (lavados y secos*)','" + miercoles + " - 12 - 2019')";
            miercoles += 7;
            db.execSQL(insertEventosFijos);
        }

        //EVENTOS VIERNES:

        //ENERO:
        int viernes = 25;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 1 - 2019')";
        db.execSQL(insertEventosFijos);

        //FEBRERO:
        viernes = 22;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 2 - 2019')";
        db.execSQL(insertEventosFijos);

        //MARZO:
        viernes = 29;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 3 - 2019')";
        db.execSQL(insertEventosFijos);

        //ABRIL:
        viernes = 26;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 4 - 2019')";
        db.execSQL(insertEventosFijos);

        //MAYO:
        viernes = 31;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 5 - 2019')";
        db.execSQL(insertEventosFijos);

        //JUNIO:
        viernes = 28;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 6 - 2019')";
        db.execSQL(insertEventosFijos);

        //JULIO:
        viernes = 26;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 7 - 2019')";
        db.execSQL(insertEventosFijos);

        //AGOSTO:
        viernes = 30;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 8 - 2019')";
        db.execSQL(insertEventosFijos);

        //SETIEMBRE
        viernes = 27;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 9 - 2019')";
        db.execSQL(insertEventosFijos);

        //OCTUBRE:
        viernes = 25;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 10 - 2019')";
        db.execSQL(insertEventosFijos);

        //NOVIEMBRE:
        viernes = 29;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 11 - 2019')";
        db.execSQL(insertEventosFijos);

        //DICIEMBRE:
        viernes = 27;
        insertEventosFijos = "insert into eventosFijos (nombreEvento,descripcion,fechaDesde) values " +
                "('Residuos No Tradicionales','Tales como: chatarra, electrodomésticos, madera, hierro" +
                ", aceite quemado, escombros en sacos y madera','" + viernes + " - 12 - 2019')";
        db.execSQL(insertEventosFijos);
    }
}
