package com.example.adminpc.testmoter;

import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.app.*;
import android.view.*;
import android.widget.*;
import android.annotation.*;
import android.graphics.*;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private static final int REFRESH_SCREEN = 1;
    ProgressBar Progress;
    TextView txtView;

    private EditText etPercent;
    private ClipDrawable mImageDrawable;
    // a field in your class
    private int mLevel = 0;
    private int fromLevel = 0;
    private int toLevel = 0;

    //set
    public static int nomal = 20;
    public static int low = 35;
    public static int medium = 50;
    public static int high = 100;

    public static final int MAX_LEVEL = 10000;
    public static int LEVEL_DIFF = 80;
    public static final int DELAY = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Percent
        etPercent = (EditText) findViewById(R.id.etPercent);
        // imgBot
        ImageView img = (ImageView) findViewById(R.id.imgBotfull);
        mImageDrawable = (ClipDrawable) img.getDrawable();
        mImageDrawable.setLevel(0);
        // textView1
        final TextView txtView1 = (TextView) findViewById(R.id.textView1);
        // switch1
        final Switch switchT1 = (Switch) findViewById(R.id.btnConnect);
        switchT1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (switchT1.isChecked() == true) {
                    // progressBar1
                    Progress = (ProgressBar) findViewById(R.id.progressBar1);
                    txtView = (TextView) findViewById(R.id.textView1);
                    startScan(); // Sleep
                } else {
                    txtView1.setText("Status : No Connect");
                    Toast.makeText(MainActivity.this,
                            String.valueOf("Status : No Connect"),
                            Toast.LENGTH_SHORT).show();
                    txtView1.setTextColor(Color.RED);
                }

            }
        });
    }

    private Handler mUpHandler = new Handler();
    private Runnable animateUpImage = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimation(fromLevel, toLevel);
        }
    };

    private Handler mDownHandler = new Handler();
    private Runnable animateDownImage = new Runnable() {

        @Override
        public void run() {
            doTheDownAnimation(fromLevel, toLevel);
        }
    };



    private void doTheUpAnimation(int fromLevel, int toLevel) {
        mLevel += LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel <= toLevel) {
            mUpHandler.postDelayed(animateUpImage, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;
        }
    }

    private void doTheDownAnimation(int fromLevel, int toLevel) {
        mLevel -= LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel >= toLevel) {
            mDownHandler.postDelayed(animateDownImage, DELAY);
        } else {
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;
        }
    }

    public void onClickOk(View v) {
        int temp_level = ((Integer.parseInt(etPercent.getText().toString())) * MAX_LEVEL) / 100;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
            Toast.makeText(getApplicationContext(), "INPUT", Toast.LENGTH_SHORT).show();
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
        }
    }

    public void btnStart(View v) {
        LEVEL_DIFF = nomal;

        int temp_level = 0;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);

        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
            Toast.makeText(getApplicationContext(), "STRAT", Toast.LENGTH_SHORT).show();

        }
    }

    public void btnStop(View v) {
        System.exit(0);
    }

    public void btnLow(View v) {

        LEVEL_DIFF = low;

        int temp_level = 0;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
            Toast.makeText(getApplicationContext(), "STRAT", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnNomal(View v) {

        LEVEL_DIFF = medium;

        int temp_level = 0;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
            Toast.makeText(getApplicationContext(), "STRAT", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnHigh(View v) {

        LEVEL_DIFF = high;

        int temp_level = 0;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
            Toast.makeText(getApplicationContext(), "STRAT", Toast.LENGTH_SHORT).show();
        }
    }

    public void startScan() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    hRefresh.sendEmptyMessage(REFRESH_SCREEN);
                } catch (Exception e) {
                }
            }
        }.start();
    }

    Handler hRefresh = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_SCREEN:
                    Progress.setVisibility(View.INVISIBLE); // Hide ProgressBar
                    ShowText();
                    break;
                default:
                    break;
            }
        }
    };

    public void ShowText() {
        txtView.setText("Status : Connect");
        txtView.setVisibility(View.VISIBLE); // Show Text
        Toast.makeText(MainActivity.this,
                String.valueOf("Status : Connect"),
                Toast.LENGTH_SHORT).show();
        txtView.setTextColor(Color.GREEN);
    }
}
