package UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    Button btn_login;
    EditText txt_username, txt_password;
    TextView txt_register;
    ProgressDialog pDialog;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ID = "id";
    public static final String USERNAME = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_login = (Button) findViewById(R.id.login);
        txt_register = (TextView) findViewById(R.id.register);
        txt_username = (EditText) findViewById(R.id.username);
        txt_password = (EditText) findViewById(R.id.password);


        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = txt_username.getText().toString();
                final String password = txt_password.getText().toString();
                Log.d("dddd", username + password);
                AndroidNetworking.post("http://192.168.6.77/Jastip/login.php")
                        .addBodyParameter("username", txt_username.getText().toString())
                        .addBodyParameter("password", txt_password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                if ((username.isEmpty()) || (password.isEmpty())) {
                                    Toast.makeText(LoginActivity.this, "semuanya harus di isi", Toast.LENGTH_SHORT).show();
                                } else {

                                    try {
                                        int suksess = response.getInt("suksess");
                                        int id = response.getInt("id");
                                        if (suksess == 1) {
                                            Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                                            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString(ID, String.valueOf(id));
                                            editor.putString(USERNAME, String.valueOf(username));
                                            editor.apply();
                                            Intent in = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(in);
                                            finish();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }


                            }

                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(LoginActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });


    }

}
