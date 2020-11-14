package com.example.tp22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private AssistStructure.ViewNode textView;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show);


        View editText = findViewById(R.id.editText);



        if (savedInstanceState != null) {
            boolean Visible =
                    savedInstanceState.getBoolean("reply_visible");

            if (Visible) {
                mShowCount.setText(savedInstanceState
                        .getString("count"));
                mShowCount.setVisibility(View.VISIBLE);

            }
        }
        Log.d(TAG,"Q1:Le compteur est réinitialisé à 0, mais le contenu de l'EditText est préservé.");
        Log.d(TAG,"Q2: Android arrête votre activité en appelant onPause(), onStop() et onDestroy(), puis redémarre l'opération en appelant onCreate(), onStart() et onResume().");
        Log.d(TAG,"Q3: onSaveInstanceState() est appelée avant la méthode onStop()");
        Log.d(TAG,"Q4:onPause() ou onStop()");

    }
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

        }
    }



    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("count",
                    mShowCount.getText().toString());

        }
    }
}