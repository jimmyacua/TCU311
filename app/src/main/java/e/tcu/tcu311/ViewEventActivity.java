package e.tcu.tcu311;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewEventActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private SQLiteDatabase db;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        listView = (ListView) findViewById(R.id.itvListaEventos);
        listView.setOnItemLongClickListener(this);

        Bundle bundle = getIntent().getExtras();
        int dia, mes, anio;
        dia = 0; mes = 0; anio = 0;
        dia = bundle.getInt("dia");
        mes = bundle.getInt("mes");
        anio = bundle.getInt("anio");
        String cadena = dia + " - " + mes + " - " + anio;

        BDSQLite bd = new BDSQLite(getApplication(), "Agenda", null, 1);
        db = bd.getReadableDatabase();

        String sql = "select * from eventos where fechaDesde = '"+ cadena +"'";
        String sqlFijos = "select * from eventosFijos where fechaDesde = '"+ cadena +"'";
        Cursor c, cFijos;

        String nombre, fechaDesde, horaInicio, descripcion;
        boolean existeEventoFijo, existeEvento;
        existeEvento = existeEventoFijo = false;
        try{
            c = db.rawQuery(sql, null);
            cFijos = db.rawQuery(sqlFijos, null);
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
            if(cFijos.moveToFirst()){
                existeEventoFijo = true;
                do{
                    nombre = cFijos.getString(1);
                    descripcion = cFijos.getString(2);
                    fechaDesde = cFijos.getString(3);
                    arrayAdapter.add(nombre+", "+ descripcion+", Fecha: "+fechaDesde);
                } while (cFijos.moveToNext());
                listView.setAdapter(arrayAdapter);
                cFijos.close();
            }
            if(c.moveToFirst()){
                existeEvento = true;
                do{
                    nombre = c.getString(1);
                    descripcion = c.getString(2);
                    fechaDesde = c.getString(3);
                    horaInicio = c.getString(4);
                    arrayAdapter.add(nombre+", "+ descripcion+", Fecha: "+fechaDesde+", Hora: "+horaInicio);
                } while (c.moveToNext());
                listView.setAdapter(arrayAdapter);
                c.close();
            }
            if(!existeEvento && !existeEventoFijo){
                Toast.makeText(getApplication(),"No existen eventos ese día", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }catch (Exception e){
            Toast.makeText(getApplication(),"Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    private void eliminar(String dato){
        String [] datos = dato.split(", ");
        String sql = "delete from eventos where nombreEvento = '"+datos[0]+"' and descripcion = '"+datos[1]+"'"
                + " and fechaDesde = '"+datos[2]+"' and horaDesde = '"+datos[3]+"'";
        try {
            arrayAdapter.remove(dato);
            listView.setAdapter(arrayAdapter);
            db.execSQL(sql);
            Toast.makeText(getApplication(), "Evento eliminado", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplication(), "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence [] items = new CharSequence[2];
        items[0] = "Eliminar";
        items[1] = "Cancelar";
        builder.setTitle("Eliminar evento").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which ==0){
                    //eliminar evento
                    eliminar(parent.getItemAtPosition(position).toString());
                } else{
                    //cancelar
                    return;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return false;
    }
}
