package com.example.firza.firza_1202150018_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    private EditText ToDo, Description, Priority;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        setTitle("Add To Do");


        ToDo = (EditText) findViewById(R.id.edt_Todo);
        Description = (EditText) findViewById(R.id.edt_Desc);
        Priority = (EditText) findViewById(R.id.edt_Priority);
        db = new Database(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddToDo.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void addTodo(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //maka akan menampilkan toast bahwa data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List Ditambahkan !", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(AddToDo.this, MainActivity.class));
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "List tidak boleh kosong", Toast.LENGTH_SHORT).show();

            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }

}
