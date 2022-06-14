package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityProductosBinding;
import co.edu.cesde.databinding.ActivityRegister2Binding;

public class Activity_Productos extends AppCompatActivity {

    private ActivityProductosBinding productosBinding;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productosBinding = ActivityProductosBinding.inflate(getLayoutInflater());
        View view = productosBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);


    }
    public void goTobuscar(){
        Intent intent = new Intent(this,FindProductActivity.class);
        startActivity(intent);
    }
    public void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void inClick(View v){
        switch (v.getId()){
            case R.id.btnirabuscar:
                goTobuscar();
                break;

            case R.id.btnirmain:
                goToMain();
                break;


        }
    }

    public void registerProducto (View view){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues userDate = new ContentValues();
        String nomProducto = productosBinding.etnom.getText().toString();
        String cod = productosBinding.etcodigo.getText().toString();
        String descrip = productosBinding.etdescripcion.getText().toString();
        String fabricante = productosBinding.etfabricante.getText().toString();
        String preUni = productosBinding.etprecio.getText().toString();
        String categoria = productosBinding.etcategoria.getText().toString();

        userDate.put("nomProducto", nomProducto);
        userDate.put("cod", cod);
        userDate.put("descrip", descrip);
        userDate.put("fabricante", fabricante);
        userDate.put("preUni", preUni);
        userDate.put("categoria", categoria);

        long  newUser = db.insert("productos", null, userDate);
        Toast.makeText(this, "" + newUser, Toast.LENGTH_SHORT).show();
    }

}
