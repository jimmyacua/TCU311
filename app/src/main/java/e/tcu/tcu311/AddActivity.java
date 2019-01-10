package e.tcu.tcu311;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreEvento, descripcion, fechaDesde, horaDesde, fechaHasta, horaHasta;
    private Spinner horas, minutos, dias, meses, anios;
    private Button guardar, cancelar;
    private String fecha, hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        fecha = "01 - 01 - 1980";
        hora = "00:00";
        nombreEvento = (EditText) findViewById(R.id.edtNombreEvento);
        descripcion = (EditText) findViewById(R.id.edtDescripción);
        //fechaDesde = (EditText) findViewById(R.id.edtFechaDesde);
        //horaDesde = (EditText) findViewById(R.id.edtHoraInicio);
        //fechaHasta = (EditText) findViewById(R.id.edtFechaHasta);
        //horaHasta = (EditText) findViewById(R.id.edtHoraHasta);
        horas = (Spinner) findViewById(R.id.spinnerHoras);
        minutos = (Spinner) findViewById(R.id.spinnerMinutos);
        dias = (Spinner) findViewById(R.id.spinnerDias);
        meses = (Spinner) findViewById(R.id.spinnerMes);
        anios = (Spinner) findViewById(R.id.spinnerAnio);

        ArrayAdapter<CharSequence> adapterHoras = ArrayAdapter.createFromResource(this,R.array.horas, R.layout.support_simple_spinner_dropdown_item);
        horas.setAdapter(adapterHoras);
        ArrayAdapter<CharSequence> adapterMinutos = ArrayAdapter.createFromResource(this,R.array.minutos, R.layout.support_simple_spinner_dropdown_item);
        minutos.setAdapter(adapterMinutos);


        ArrayAdapter<CharSequence> adapterDias = ArrayAdapter.createFromResource(this,R.array.dias, R.layout.support_simple_spinner_dropdown_item);
        dias.setAdapter(adapterDias);
        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,R.array.mes, R.layout.support_simple_spinner_dropdown_item);
        meses.setAdapter(adapterMes);
        ArrayAdapter<CharSequence> adapterAnio = ArrayAdapter.createFromResource(this,R.array.anio, R.layout.support_simple_spinner_dropdown_item);
        anios.setAdapter(adapterAnio);

        Bundle bundle = getIntent().getExtras();
        //int dia = 0, mes = 0, anio = 0;
        //dia = bundle.getInt("dia");
        //mes = bundle.getInt("mes");
        //anio = bundle.getInt("anio");
        //fechaDesde.setText(dia+" - " + mes +" - " + anio);


        guardar = (Button) findViewById(R.id.btnGuardar);
        cancelar = (Button) findViewById(R.id.btnCancelar);

        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == guardar.getId()){
            //guarda los datos de las cajas de texto
            BDSQLite bd = new BDSQLite(getApplication(), "Agenda", null, 1);
            SQLiteDatabase db = bd.getWritableDatabase();

            fecha = dias.getSelectedItem().toString() + " - " + meses.getSelectedItem().toString()
                    +" - "+ anios.getSelectedItem().toString();

            hora = horas.getSelectedItem().toString() + ":" + minutos.getSelectedItem().toString()+":"+"00";

            /*"idEvento int identity, " +
            "nombreEvento varchar(50), " +
            "descripcion varchar(100), " +
            "fechaDesde date, " +
            "horaDesde time, " +
            "fechaHasta date, " +
            "horaHasta time)";
            */
            String sql = "insert into eventos"+
                    "(nombreEvento,descripcion,fechaDesde , horaDesde) values ('" +
                    nombreEvento.getText() +
                    "','" + descripcion.getText() +
                    "','" + fecha +
                    "','" + hora +
                    "')";

            try {
                db.execSQL(sql);
                nombreEvento.setText("");
                descripcion.setText("");
                fecha = "01 - 01 - 1980";
                hora = "00:00";
                Toast.makeText(getApplication(), "Evento Agregado", Toast.LENGTH_SHORT).show();

                //String select = "select * from eventos";
                //Cursor c = db.rawQuery(select,null);
                //Toast.makeText(getApplication(),c.getString(1), Toast.LENGTH_LONG).show();
                //System.out.println(db.rawQuery(select,null));

                //fechaHasta.setText("");
                //horaHasta.setText("");
            }
            catch (Exception e){
                Toast.makeText(getApplication(), "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            this.finish();

        } else{
            this.finish();
        }
        return;
    }
}
