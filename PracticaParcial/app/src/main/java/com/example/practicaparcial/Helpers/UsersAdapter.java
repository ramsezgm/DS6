package com.example.practicaparcial.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicaparcial.Models.Users;
import com.example.practicaparcial.R;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<Users> {

    List<Users> users;

    public UsersAdapter(Context context, List<Users> users){
        super(context, R.layout.list_view_users, users);
        this.users = users;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_view_users, null);

        TextView nombre = item.findViewById(R.id.nombre);
        nombre.setText(users.get(position).getNombre());

        TextView apellido = item.findViewById(R.id.apellido);
        apellido.setText(users.get(position).getApellido());

        TextView edad = item.findViewById(R.id.edad);
        edad.setText(users.get(position).getEdad());

        TextView cedula = item.findViewById(R.id.cedula);
        cedula.setText(users.get(position).getCedula());

        TextView nacionalidad = item.findViewById(R.id.nacionalidad);
        nacionalidad.setText(users.get(position).getNacionalidad());

        return item;
    }
}
