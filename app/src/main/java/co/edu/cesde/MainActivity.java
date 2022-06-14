package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    private ActivityMainBinding mainBinding;
    DbHelper dbHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        mainBinding.btnSingIn.setOnClickListener(this);
        mainBinding.btnSingInWith.setOnClickListener(this);
    }
    public void showMessage(){
        Intent intent= new Intent(MainActivity.this,Activity_Productos.class);
        startActivity(intent);
    }

    public void goToRegister(){
        Intent intent = new Intent(MainActivity.this,Activity_Register2.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSingIn:
                showMessage();
                break;

            case R.id.btnSingInWith:
                goToRegister();
                break;

        }
    }
}
