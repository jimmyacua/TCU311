package e.tcu.tcu311;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreEvento, descripcion, fechaDesde, horaDesde, fechaHasta, horaHasta;

    private Button guardar, cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombreEvento = (EditText) findViewById(R.id.edtNombreEvento);
        descripcion = (EditText) findViewById(R.id.edtDescripción);
        fechaDesde = (EditText) findViewById(R.id.edtFechaDesde);
        horaDesde = (EditText) findViewById(R.id.edtHoraInicio);
        fechaHasta = (EditText) findViewById(R.id.edtFechaHasta);
        horaHasta = (EditText) findViewById(R.id.edtHoraHasta);

        Bundle bundle = getIntent().getExtras();
        int dia = 0, mes = 0, anio = 0;
        bundle.getInt("dia");
        bundle.getInt("mes");
        bundle.getInt("anio");
        fechaDesde.setText(dia+" - " + mes +" - " + anio);
        fechaHasta.setText(dia+" - " + mes +" - " + anio);

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

            /*"idEvento int identity, " +
            "nombreEvento varchar(50), " +
            "descripcion varchar(100), " +
            "fechaDesde date, " +
            "horaDesde time, " +
            "fechaHasta date, " +
            "horaHasta time)";
            */
            String sql = "insert into eventos+"+
                    "(nombreEvento,descripcion,fechaDesde , horaDesde, fechaHasta, horaHasta) values ('" +
                    nombreEvento.getText() +
                    "','" + descripcion.getText() +
                    "','" + fechaDesde.getText() +
                    "','" + horaDesde.getText() +
                    "','" + fechaHasta.getText() +
                    "','" + horaHasta.getText() +
                    "')";
            try {
                db.execSQL(sql);
                nombreEvento.setText("");
                descripcion.setText("");
                fechaDesde.setText("");
                horaDesde.setText("");
                fechaHasta.setText("");
                horaHasta.setText("");
            }
            catch (Exception e){
                Toast.makeText(getApplication(), "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else{
            this.finish();
            return;
        }
    }
}
