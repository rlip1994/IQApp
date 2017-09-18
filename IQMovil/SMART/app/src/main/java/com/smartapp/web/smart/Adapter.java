package com.smartapp.web.smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by klcho.o on 12/9/2017.
 */

public abstract class Adapter extends BaseAdapter {


    private ArrayList<?> child_list;
    private int R_layout_IdView;
    private Context context;

    /*
    *  Se le pasa el contexto del app,id del layout entrada y el arraylist con los datos
    */

    public Adapter(Context pContext, int pR_layout_IdView, ArrayList<?> pChildList) {
        super();
        this.context = pContext;
        this.child_list = pChildList;
        this.R_layout_IdView = pR_layout_IdView;
    }

    @Override
    public View getView(int pos, View view, ViewGroup relation) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null);
        }
        onEntrada (child_list.get(pos), view);
        return view;
    }

    @Override
    public int getCount() {
        return child_list.size();
    }

    @Override
    public Object getItem(int pos) {
        return child_list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     */
    public abstract void onEntrada (Object child_list, View view);

}
