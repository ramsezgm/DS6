package com.example.practicaparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddUserActivity extends AppCompatActivity {

    EditText nombre, apellido, edad, cedula, nacionalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        inicializarControles();
    }

    private void inicializarControles(){
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        edad = findViewById(R.id.txtEdad);
        cedula = findViewById(R.id.txtCed);
        nacionalidad = findViewById(R.id.txtNacion);
    }

    public int guardarEnArchivo(String usuario){
        try{
            if(archivoExiste()){
                sobreescribirArchivo(usuario);
            }
            else{
                OutputStreamWriter out = new OutputStreamWriter(
                        openFileOutput("usuarios.txt",Context.MODE_PRIVATE));

                out.write(usuario);
                out.close();
            }
            return 1;
        }
        catch (Exception e){
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
        return 0;
    }

    public void register(View v){
        try{
            String user =
                    nombre.getText().toString()+"|"+
                    apellido.getText().toString()+"|"+
                    edad.getText().toString()+"|"+
                    cedula.getText().toString()+"|"+
                    nacionalidad.getText().toString()+"~";

            int res = guardarEnArchivo(user);
            if(res == 1){
                this.notify("sisepudo ermano, se guardo en el arch");
                startActivity(new Intent(this, MainActivity.class));
            }
            else{
                this.notify("se pudrio, no se guardo en el arch");
            }
        }
        catch (Exception e){
            this.notify("error");
        }
    }

    public void notify(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public boolean archivoExiste(){
        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(openFileInput("usuarios.txt")));
            String texto = br.readLine();
            br.close();
            if(!texto.isEmpty()){
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    public void sobreescribirArchivo(String reg){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput("usuarios.txt")));
            String texto = br.readLine();

            OutputStreamWriter out = new OutputStreamWriter(
                    openFileOutput("usuarios.txt", Context.MODE_PRIVATE));
            out.write(texto+reg);
            out.close();
        }
        catch(Exception e){
            this.notify("Error "+e.getMessage());
        }
    }
}