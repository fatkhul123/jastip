package UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jastipfinale.R;

import static UI.LoginActivity.ID;
import static UI.LoginActivity.SHARED_PREFS;

public class Splashscreen extends AppCompatActivity {
    private int SLEEP_TIMER = 1;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashscreen);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        id = sharedPreferences.getString(ID, "");
        LogoLuncher logoLuncher = new LogoLuncher();
        logoLuncher.start();
    }

    private class LogoLuncher extends Thread {
        public void run() {
            try {
                sleep(1000 * SLEEP_TIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (id.isEmpty()) {
                Intent intent = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(intent);
                Splashscreen.this.finish();
            } else {
                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);
                Splashscreen.this.finish();
            }

        }
    }
}
