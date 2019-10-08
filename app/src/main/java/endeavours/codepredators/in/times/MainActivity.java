package endeavours.codepredators.in.times;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView tableListView;

    public void generateList(int timetrack) {

        ArrayList<String> t = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            t.add(Integer.toString(i * timetrack));
        }

        ArrayAdapter<String> myarr = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, t);
        tableListView.setAdapter(myarr);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar tableSeekBar = findViewById(R.id.tableSeekBar);
        tableListView = findViewById(R.id.tableListView);

        tableSeekBar.setMax(20);
        tableSeekBar.setProgress(10);

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timetrack;

                if (progress < min) {
                    timetrack = min;
                } else {
                    timetrack = progress;
                }

                Log.i("Seekbar VAlue", Integer.toString(progress));

                Toast.makeText(getApplicationContext(),
                         " "+  progress,
                        Toast.LENGTH_LONG)
                        .show();



                generateList(timetrack);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}