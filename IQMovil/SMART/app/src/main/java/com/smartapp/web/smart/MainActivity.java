package com.smartapp.web.smart;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.TextView;

import java.net.UnknownHostException;
import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import Controllers.CategoryController;
import conexion.AppController;
import utils.Const;


public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    public static Activity activity;
    private String tag_json_obj = "jobj_req" ,tag_json_arry = "jarray_req";
    private String TAG = "Main";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        this.txtView = (TextView) findViewById(R.id.sample_text);

        try {
            CategoryController categoryController;
            categoryController =  new CategoryController();

        } catch (Exception e) {
            //e.printStackTrace();
            showAlertMessage(e.toString());
        }


        // .... ingresar los datos a un arreglo
        /**ArrayList<lista_entrada> datos = new ArrayList<lista_entrada>();

        datos.add(new lista_entrada("Niño1","8","escuela1","SJ"));
        datos.add(new lista_entrada("Niño2","9","escuela2","Al"));
        datos.add(new lista_entrada("Niño3","10","escuela3","P"));

        //..... agregar los datos al layout

        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {


                if (entrada != null) {
                    TextView texto_nombre = (TextView) view.findViewById(R.id.textView_nombre);
                    if (texto_nombre != null)
                        texto_nombre.setText(((lista_entrada) entrada).getNombreNino());

                    TextView texto_edad = (TextView) view.findViewById(R.id.textView_año);
                    if (texto_edad != null)
                        texto_edad.setText(((lista_entrada) entrada).getEdadNino());

                    TextView texto_localidad = (TextView) view.findViewById(R.id.textView_provincia);
                    if (texto_localidad != null)
                        texto_localidad.setText(((lista_entrada) entrada).getLocalidadNino());
                    TextView texto_escuela = (TextView) view.findViewById(R.id.textView_escuela);
                    if (texto_escuela != null)
                        texto_escuela.setText(((lista_entrada) entrada).getEscuelaNino());

                }
            }
        });

        //.... al seleccionar un item ir a otro layourt
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                lista_entrada itemElegido = (lista_entrada) pariente.getItemAtPosition(posicion);

                Intent Activity = new Intent(getApplicationContext(), preguntas.class);
                startActivity(Activity);
            }
        });**/


    }
    public  void showAlertMessage(String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }

}
