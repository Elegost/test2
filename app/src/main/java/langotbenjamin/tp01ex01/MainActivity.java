package langotbenjamin.tp01ex01;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextClock;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private TextClock textClockCurrentTime;
    private Chronometer chrono;
    private long timesave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = (Button) findViewById(R.id.ButtonStart);
        buttonStop = (Button) findViewById(R.id.ButtonStop);
        textClockCurrentTime = (TextClock) findViewById(R.id.textClockCurrentTime);
        chrono = (Chronometer) findViewById(R.id.chronometerElapsedTime);
        timesave = 0;
    }

    //Lancement du chrono
    public void start(View view)
    {
        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
        chrono.setBase(SystemClock.elapsedRealtime() - timesave);
        chrono.start();
    }

    //Pause du chrono
    public void stop(View view)
    {
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
        chrono.stop();
        timesave = SystemClock.elapsedRealtime() - chrono.getBase();
    }

    //Remet à 0 le chrono
    public void reset(View view)
    {
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
        chrono.stop();
        timesave = 0;
    }
}
