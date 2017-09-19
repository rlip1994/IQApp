package com.smartapp.web.smart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class childList extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_child_list);

        // .... ingresar los datos a un arreglo
        ArrayList<Child> data = new ArrayList<Child>();

        data.add(new Child("Niño1","8","escuela1","SJ"));
        data.add(new Child("Niño2","9","escuela2","Al"));
        data.add(new Child("Niño3","10","escuela3","P"));

        //..... agregar los datos al layout

        list = (ListView) findViewById(R.id.ListView_childlist);
        list.setAdapter(new Adapter_childList(this, R.layout.child_category, data){
            @Override
            public void onEntrada (Object child, View view) {
                if (child != null) {
                    TextView name = (TextView) view.findViewById(R.id.textView_name);
                    if (name != null)
                        name.setText(((Child) child).getName());

                    TextView age = (TextView) view.findViewById(R.id.textView_age);
                    if (age != null)
                        age.setText(((Child) child).getAge());

                    TextView located = (TextView) view.findViewById(R.id.textView_located);
                    if (located != null)
                        located.setText(((Child) child ).getLocate());
                    TextView school = (TextView) view.findViewById(R.id.textView_school);
                    if (school != null)
                        school.setText(((Child) child).getSchool());

                }
            }
        });

        //.... al seleccionar un item ir a otro layourt
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Child itemElegido = (Child) pariente.getItemAtPosition(posicion);

                Intent Activity = new Intent(getApplicationContext(), categoryList.class);
                startActivity(Activity);
                finish();
            }
        });


    }


}
