package com.smartapp.web.smart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import Controllers.CategoryController;
import Model.Category;

/**
 * Created by klcho.o on 16/9/2017.
 */

public class categoryList extends AppCompatActivity {

    private ListView list;
    public ProgressBar progressBar;
    ArrayList<CategoryView> dataCategoryView = new ArrayList<CategoryView>();
    private CategoryController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_category);
        list = (ListView) findViewById(R.id.ListView_Categorylist);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        this.hiddenProgressBar();
        //Start Controller
        try {
            this.controller = new CategoryController(this);
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        } catch (ExecutionException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }







    }
    /**
     * Method: change progress bar**/
    public void  showProgressBar(){
        this.progressBar.setVisibility(View.VISIBLE);
    }
    public void  hiddenProgressBar(){
        this.progressBar.setVisibility(View.INVISIBLE);
    }

     public void addCategoryViewData(String nameCategory){
         dataCategoryView.add(new CategoryView(nameCategory,R.drawable.ic_filter_vintage_black_24dp));
     }

     public void setListAdapter(){
         list.setAdapter(new Adapter_Category(this, R.layout.category_format, dataCategoryView) {
             @Override
             public void onAdaptarCategory(Object category, View view) {
                 if (category != null) {
                     TextView categoryName = (TextView) view.findViewById(R.id.textView_superior);
                     if (categoryName != null)
                         categoryName.setText(((CategoryView) category).getCategory());

                     ImageView image= (ImageView) view.findViewById(R.id.imageView_imagen);
                     if (image != null)
                         image.setImageResource(((CategoryView) category).getImage());
                 }
             }
         });
     }
     public void setListClickListener(){
         list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                 CategoryView elegido = (CategoryView) pariente.getItemAtPosition(posicion);
                 Intent intent = new Intent(getApplicationContext(),questionsText.class);
                 startActivity(intent);
                 finish();
             }
         });
     }
}
