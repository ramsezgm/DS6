package com.example.practicaparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practicaparcial.Helpers.UsersAdapter;
import com.example.practicaparcial.Models.Users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ViewUsersActivity extends AppCompatActivity {

    UsersAdapter compAdapter;
    ListView lstUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        lstUsuarios = findViewById(R.id.lstUsuarios);
        compAdapter = new UsersAdapter(this, fileToList());
        lstUsuarios.setAdapter(compAdapter);

    }


    private List<Users> fileToList(){
        List<Users> users = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput("usuarios.txt")));
            String datos = br.readLine();

            String[] arrUsuarios = datos.split("~");

            for(String strUsuario : arrUsuarios){
                String[] camposUser = strUsuario.split("\\|");
                Users usuario = new Users(
                        camposUser[0],
                        camposUser[1],
                        Integer.parseInt(camposUser[2]),
                        camposUser[3],
                        camposUser[4]
                );
                users.add(usuario);
            }

        }
        catch(Exception e){
            notify("error aki al pasar el file a lista");
        }
        return users;
    }

    private void notify(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

}