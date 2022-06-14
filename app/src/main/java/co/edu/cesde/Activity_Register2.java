package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityMainBinding;
import co.edu.cesde.databinding.ActivityRegister2Binding;

public class Activity_Register2 extends AppCompatActivity {

    private ActivityRegister2Binding register2Binding;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        register2Binding = ActivityRegister2Binding.inflate(getLayoutInflater());
        View view = register2Binding.getRoot();
        setContentView(view);


    }

    public void goTobuscar(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void inClick(View v){
        switch (v.getId()){
            case R.id.btnirmain2:
                goTobuscar();
                break;
        }
    }
    public void registerUser(View view){
        dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues userData = new ContentValues();
        String name = register2Binding.etName.getText().toString();
        String email = register2Binding.etEmail.getText().toString();
        String identification = register2Binding.etIdentification.getText().toString();
        String password = register2Binding.etPassword.getText().toString();

        userData.put("name", name);
        userData.put("email", email);
        userData.put("identification", identification);
        userData.put("password", password);

        long  newUser = db.insert("users", null, userData);
        Toast.makeText(this, "" + newUser, Toast.LENGTH_SHORT).show();
    }

}