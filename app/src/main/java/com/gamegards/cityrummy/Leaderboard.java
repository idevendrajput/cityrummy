package com.gamegards.cityrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.gamegards.cityrummy.databinding.ActivityLeaderboardBinding;

public class Leaderboard extends AppCompatActivity {

    private ActivityLeaderboardBinding binding;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaderboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actions();
        updateUi();

    }

    private void actions() {

        binding.imgclosetop.setOnClickListener(view -> {
            finish();
        });

    }

    private void updateUi() {

        new Handler()
                .postDelayed(() -> {
                    binding.rltProgress.setVisibility(View.GONE);
                    binding.txtnotfound.setVisibility(View.VISIBLE);
                }, 2000);

    }

}