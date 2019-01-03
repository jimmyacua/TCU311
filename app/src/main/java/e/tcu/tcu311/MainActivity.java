package e.tcu.tcu311;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CharSequence[] items = new CharSequence[3];
        items[0] = "Agregar Evento";
        items[1] = "Ver Eventos";
        items[2] = "Cancelar";

        final int dia, mes, anio;
        dia = dayOfMonth;
        mes = month+1;
        anio = year;


        builder.setTitle("Seleccione una opción").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    //agregar evento
                    Intent intent = new Intent(getApplication(), AddActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("dia", dia);
                    bundle.putInt("mes", mes);
                    bundle.putInt("anio", anio);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(which==1){
                    //ver eventos
                    Intent intent = new Intent(getApplication(), ViewEventActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("dia", dia);
                    bundle.putInt("mes", mes);
                    bundle.putInt("anio", anio);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else{
                    //cancelar
                    return;
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
