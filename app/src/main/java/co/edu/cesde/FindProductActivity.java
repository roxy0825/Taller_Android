package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityFindProductBinding;

public class FindProductActivity extends AppCompatActivity {
        private ActivityFindProductBinding productBinding;
         DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding = ActivityFindProductBinding.inflate(getLayoutInflater());
        View view = productBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
    }
    public void irAProductos(){
        Intent intent = new Intent(this,Activity_Productos.class);
        startActivity(intent);
    }
    public void enClick(View v){
        switch (v.getId()){
            case R.id.btnBuscar2:
                irAProductos();
                break;
        }
    }
    public void find(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String usertoFind = productBinding.etBuscar4.getText().toString();
        Cursor cursor = db.rawQuery("SELECT * FROM productos WHERE cod = "+ usertoFind, null);
        cursor.moveToNext();
        String cod = cursor.getString(3);
        productBinding.tvProducName.setText(cod);

    }
}