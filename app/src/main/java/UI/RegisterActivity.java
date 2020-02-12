package UI;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.jastipfinale.R;

import org.json.JSONObject;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    Button btn_register;
    EditText txt_username, txt_password, kelass, emaill;
    Intent intent;
    TextView login;
    HashMap<String, String> hashMap = new HashMap<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Assign Id'S
        btn_register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        txt_username = (EditText) findViewById(R.id.username);
        txt_password = (EditText) findViewById(R.id.password);
        kelass = findViewById(R.id.kelas);
        emaill = findViewById(R.id.email);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.post("http://192.168.6.77/Jastip/register.php")
                        .addBodyParameter("username", txt_username.getText().toString())
                        .addBodyParameter("kelas", kelass.getText().toString())
                        .addBodyParameter("email", emaill.getText().toString())
                        .addBodyParameter("password", txt_password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                String username = txt_username.getText().toString();
                                String password = txt_password.getText().toString();
                                String kelas = kelass.getText().toString();
                                String email = emaill.getText().toString();

                                if ((username.isEmpty()) || (password.isEmpty()) || (kelas.isEmpty()) || (email.isEmpty())) {
                                    Toast.makeText(RegisterActivity.this, "semuanya harus di isi", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(in);
                                }
                            }

                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(RegisterActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });


    }


}




