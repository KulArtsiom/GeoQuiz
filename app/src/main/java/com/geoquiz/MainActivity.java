package com.geoquiz;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_true)
    void onClickTrue() {
        showToast(this, this.getResources().getString(R.string.correct_toast));
    }

    @OnClick(R.id.btn_false)
    void onClickFalse() {
        showToast(this, this.getResources().getString(R.string.incorrect_toast));
    }

    private void showToast(Activity activity, String message){
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
