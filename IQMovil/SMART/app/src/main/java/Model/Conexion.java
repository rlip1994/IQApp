package Model;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.smartapp.web.smart.MainActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;

/**
 * Created by Katerine on 23/4/2017.
 */
public class Conexion extends AsyncTask<String, Void, String>{
    private HttpURLConnection conexion;
    private URL url;
    private String port = ":3000";
    private String method;
    private Boolean outputFlag;
    private Boolean inputFlag;


    private void  conexionHttp() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
        httpURLConnection.setRequestMethod(this.method);
        httpURLConnection.setDoOutput(outputFlag);
        httpURLConnection.setDoInput(inputFlag);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.connect();
        this.conexion = httpURLConnection;
    }

    private String consultarWebService(String datosPost)  {
        try {
            this.enviarPost(datosPost);
            return this.getResponse();
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }finally {
            this.conexionDisconnect();
        }
    }

    public static String crearDatosPost(String[]... datos) throws UnsupportedEncodingException {
        String datos_post="";
        for (String[] dato :datos){
            datos_post += URLEncoder.encode(dato[0], "UTF-8") + "=" + URLEncoder.encode(dato[1], "UTF-8") + "&";
        }
        return datos_post;
    }

    private void enviarPost(String datos) throws IOException {
        OutputStream outputStream =this.conexion.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(datos);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
    }

    private  String getResponse() throws IOException {
        InputStream inputStream = this.conexion.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1")); //"iso-8859-1"
        String result="";
        String line="";
        while ((line = bufferedReader.readLine()) != null){
            result += line;
            //Toast.makeText(MainActivity.activity,result,Toast.LENGTH_LONG).show();
        }
        bufferedReader.close();
        inputStream.close();
        this.conexionDisconnect();
        return result;

    }
    private void conexionDisconnect(){ this.conexion.disconnect();
    }


    @Override
    /**
     * @Params
     * Param[0] : Server URL
     * Param[1] : Method
     * Param[2] : OutPut response
     * Param[3] : input  send
     * **/
    protected String doInBackground(String... params) {
        try {
            showAlertMessage("Inicio de ",MainActivity.activity);
            this.createDynamicUrl(params[0]);
            this.method = params[1];
            this.outputFlag = Boolean.valueOf(params[2]);
            this.inputFlag = Boolean.valueOf(params[3]);
            Toast.makeText(MainActivity.activity,"Inicio conexion ",Toast.LENGTH_LONG ).show();
            this.conexionHttp();
            Toast.makeText(MainActivity.activity,"Finaliza conexion",Toast.LENGTH_LONG ).show();

            return "Respuesta:"+this.getResponse();

        }catch (Exception e) {
            showAlertMessage("Error from conexion's thread:"+e.toString(),MainActivity.activity);
           return null;
        } finally {
            this.conexionDisconnect();
        }

    }

    public void createDynamicUrl(String pService) throws UnknownHostException {
        InetAddress local;
        local = InetAddress.getLocalHost();
        try {
            this.url = new URL("http://"+local.getHostAddress()+port+pService);
        } catch (MalformedURLException e) {
            this.showAlertMessage("Error from createUrlDynamic:"+e.getMessage(),MainActivity.activity);
            Toast.makeText(MainActivity.activity,"http://"+local.getHostAddress()+port+pService,Toast.LENGTH_LONG ).show();
        }
    }
    private  void showAlertMessage(String pMessage, Activity pActivity){
        AlertDialog alertDialog = new AlertDialog.Builder(pActivity).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }

}
