package com.smartapp.web.smart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by klcho.o on 16/9/2017.
 */

public class categoryList extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_category);


        ArrayList<Category> data = new ArrayList<Category>();

        data.add(new Category("categoria1",R.drawable.ic_filter_vintage_black_24dp));
        data.add(new Category("categoria2",R.drawable.ic_filter_vintage_black_24dp));

        list = (ListView) findViewById(R.id.ListView_Categorylist);
        list.setAdapter(new Adapter_Category(this, R.layout.category_format, data) {
            @Override
            public void onAdaptarCategory(Object category, View view) {
                if (category != null) {
                    TextView categoryName = (TextView) view.findViewById(R.id.textView_superior);
                    if (categoryName != null)
                        categoryName.setText(((Category) category).getCategory());

                    ImageView image= (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (image != null)
                        image.setImageResource(((Category) category).getImage());
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Category elegido = (Category) pariente.getItemAtPosition(posicion);
                Intent intent = new Intent(getApplicationContext(),questionsText.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
