package com.smartapp.web.smart;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class lista_entrada {

    private String nombreNino;
    private String edadNino;
    private String localidadNino;
    private String escuelaNino;

    public lista_entrada (String pNombreNino,String pEdadNino,String pLocalidadNino,String pEscuelaNino) {
        this.nombreNino = pNombreNino;
        this.edadNino = pEdadNino;
        this.localidadNino = pLocalidadNino;
        this.escuelaNino = pEscuelaNino;
    }

    public String getNombreNino() {
        return nombreNino;
    }

    public String getEdadNino() {
        return edadNino;
    }

    public String getLocalidadNino() {
        return localidadNino;
    }

    public String getEscuelaNino() {
        return escuelaNino;
    }
}