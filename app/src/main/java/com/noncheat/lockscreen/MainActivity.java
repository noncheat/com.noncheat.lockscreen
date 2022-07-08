package com.noncheat.lockscreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runAsRoot();
    }

    private void runAsRoot() {
        try {
            // Executes the command.
            Runtime.getRuntime().exec("su -c input keyevent KEYCODE_POWER");
            finishAndRemoveTask();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Root permission required", Toast.LENGTH_SHORT).show();
            finishAndRemoveTask();
        }
    }
}
