package com.jdcasas.lab_4_2act4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.jdcasas.lab_4_2act4.R.string.text;

public class SegundaActividad extends AppCompatActivity {

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //MENU DE BOTONES
    //boton web
    public void boton1(View view) {
        String url = "http://www.google.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //boton telefono
    public void boton2(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    //boton marcar numero telefonico
    public void boton3(View view) {
        String number = "995949259";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

    }

    //añadir contactos
    public void boton4(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivity(intent);
    }

    //alarma
    public void boton5(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        startActivity(intent);
    }

    //enviar correo
    public void boton6(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", getResources().getString(R.string.mail),null));
        intent.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.subject));
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.envio)));

    }


    //iniciar camara
    public void boton7(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    //iniciar camara video
    public void boton8(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        startActivity(intent);
    }

    //gps
    public void boton9(View view) {
       Intent intent = new Intent(Intent.ACTION_VIEW);
       intent.setData(Uri.parse("https://www.google.com.pe/maps/search/universidad+nacional+de+ingenieria/data=!4m2!2m1!4b1?sa=X&hl=es-MX&nogmmr=1"));
       startActivity(intent);
	}

    //comparte texto
    public void boton10(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(text));
        intent.setType("text/plain");
        startActivity(intent);
    }

}
