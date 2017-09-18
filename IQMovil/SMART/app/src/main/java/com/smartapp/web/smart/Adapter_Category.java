package com.smartapp.web.smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by klcho.o on 16/9/2017.
 */

public abstract class Adapter_Category extends BaseAdapter {


    private ArrayList<?> category_list;
    private int R_layout_IdView;
    private Context context;

    /*
    *  Se le pasa el contexto del app,id del layout formato y el arraylist con los datos
    */

    public Adapter_Category(Context pContext, int pR_layout_IdView, ArrayList<?> pCategoryList) {
        super();
        this.context = pContext;
        this.category_list = pCategoryList;
        this.R_layout_IdView = pR_layout_IdView;
    }

    @Override
    public View getView(int pos, View view, ViewGroup relation) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null);
        }
        onAdaptarCategory (category_list.get(pos), view);
        return view;
    }

    @Override
    public int getCount() {
        return category_list.size();
    }

    @Override
    public Object getItem(int pos) {
        return category_list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     */
    public abstract void onAdaptarCategory (Object child_list, View view);


}
