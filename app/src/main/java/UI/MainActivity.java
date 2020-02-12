package UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jastipfinale.R;

import java.util.ArrayList;

import Adapter.AdapterRecycler;
import Adapter.Warung;

import static UI.LoginActivity.USERNAME;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecycler adapter;
    private ArrayList<Warung> warungArrayList;
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
         ImageView profile = findViewById(R.id.userpict);
            final TextView tuser = findViewById(R.id.textViewUser);

        adapter = new AdapterRecycler(warungArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(MainActivity.this, User.class);
                startActivity(in);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String username = sharedPreferences.getString(USERNAME, "");
        tuser.setText( "Hello " + username);

    }

    void addData(){
        warungArrayList = new ArrayList<>();
        warungArrayList.add(new Warung("Bu Tam"));
        warungArrayList.add(new Warung("Bu Wati"));
        warungArrayList.add(new Warung("Kantin Koperasi"));
        warungArrayList.add(new Warung("Rus Mart"));
        warungArrayList.add(new Warung("Teh Poci"));

}

}