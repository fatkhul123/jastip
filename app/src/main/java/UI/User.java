package UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jastipfinale.R;

    public class User extends AppCompatActivity {
        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String KELAS = "kelas";
        public static final String EMAIL = "email";

        private Toolbar toolbar;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            this.setTitle("Account Info");



            final TextView user = findViewById(R.id.username);
            final TextView email = findViewById(R.id.email);
            final TextView nama = findViewById(R.id.line1);
            final TextView kelas = findViewById(R.id.line2);
            TextView emaill = findViewById(R.id.line3);
            RelativeLayout logout = findViewById(R.id.logout);

    //        AndroidNetworking.get("http://192.168.6.53/Jastip/array.php")
    //                .setPriority(Priority.LOW)
    //                .build()
    //                .getAsJSONArray(new JSONArrayRequestListener() {
    //                    @Override
    //                    public void onResponse(JSONArray response) {
    //
    //
    //                    }
    //                    @Override
    //                    public void onError(ANError error) {
    //                        // handle error
    //                    }
    //                });


            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   finish();
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(User.this)
                            .setMessage("Anda yakin ingin keluar ?")
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    {


                                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.clear();
                                        editor.commit();
                                        Intent in = new Intent(User.this, LoginActivity.class);
                                        startActivity(in);
                                        finish();
                                    }
                                }

                            })

                            .show();
                }
            });


        }

    }
