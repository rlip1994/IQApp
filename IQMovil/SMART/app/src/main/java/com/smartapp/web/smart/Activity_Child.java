package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import controllers.UserController;


public class Activity_Child extends AppCompatActivity {

    private ListView list;
    private ArrayList<Child> dataView = new ArrayList<Child>();
    private ProgressBar progressbar;
    private UserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_child_list);
        list = (ListView) findViewById(R.id.ListView_childlist);
        this.progressbar = (ProgressBar) findViewById(R.id.progressbar);
        this.hiddenProgressBar();
        this.controller = new UserController(this);

    }

    public void addListAdapter() {
        list.setAdapter(new Adapter_childList(this, R.layout.child_category, this.dataView) {
            @Override
            public void onEntrada(Object child, View view) {
                if (child != null) {
                    TextView name = (TextView) view.findViewById(R.id.textView_name);
                    if (name != null)
                        name.setText(((Child) child).getName());

                    TextView age = (TextView) view.findViewById(R.id.textView_age);
                    if (age != null)
                        age.setText(((Child) child).getAge());

                    TextView located = (TextView) view.findViewById(R.id.textView_located);
                    if (located != null)
                        located.setText(((Child) child).getLocate());
                    TextView school = (TextView) view.findViewById(R.id.textView_school);
                    if (school != null)
                        school.setText(((Child) child).getSchool());
                }
            }
        });
    }
    public void setListClickListener() {
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Child itemSelected = (Child) pariente.getItemAtPosition(posicion);
                controller.setCurrentKid(Integer.valueOf(itemSelected.getAge())); // Actually is idKid
                controller.showMainActivity();

            }
        });
    }
    public void clearDataView(){
        this.dataView.clear();
    }

    public void addDataListView(String pId, String pName, String pGrade, String pSchool) {
        this.dataView.add(new Child(pName, pId, pSchool, pGrade));
    }


    // Edit progressBar visibility
    public void showProgressBar() {
        this.progressbar.setVisibility(View.VISIBLE);
    }

    public void hiddenProgressBar() {
        this.progressbar.setVisibility(View.INVISIBLE);
    }
}