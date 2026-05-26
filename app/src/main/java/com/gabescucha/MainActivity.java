package com.gabescucha;

import android.media.AudioManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;

public class MainActivity extends AppCompatActivity {

    private AudioManager audioManager;
    private ImageButton btnListen;
    private ImageButton btnNoiseReduction;
    private ImageButton btnBluetooth;
    private SeekBar seekBarVolume;
    private ImageButton btnVolumeUp;
    private ImageButton btnVolumeDown;
    private TextView tvStatus;
    private boolean isListening = false;

    private static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setupAudioManager();
        requestPermissions();
        setupButtonListeners();
        setupSeekBars();
    }

    private void initializeComponents() {
        btnListen = findViewById(R.id.btn_listen);
        btnNoiseReduction = findViewById(R.id.btn_noise_reduction);
        btnBluetooth = findViewById(R.id.btn_bluetooth);
        seekBarVolume = findViewById(R.id.seek_bar_volume);
        btnVolumeUp = findViewById(R.id.btn_volume_up);
        btnVolumeDown = findViewById(R.id.btn_volume_down);
        tvStatus = findViewById(R.id.tv_status);
    }

    private void setupAudioManager() {
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
    }

    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            String[] permissions = {
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.RECORD_AUDIO
            };
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void setupButtonListeners() {
        btnListen.setOnClickListener(v -> toggleListening());
        btnNoiseReduction.setOnClickListener(v -> toggleNoiseReduction());
        btnBluetooth.setOnClickListener(v -> toggleBluetooth());
        btnVolumeUp.setOnClickListener(v -> increaseVolume());
        btnVolumeDown.setOnClickListener(v -> decreaseVolume());
    }

    private void setupSeekBars() {
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        seekBarVolume.setMax(maxVolume);
        seekBarVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void toggleListening() {
        isListening = !isListening;
        if (isListening) {
            tvStatus.setText("Escuchando...");
            tvStatus.setTextColor(getResources().getColor(R.color.green));
            Toast.makeText(this, "Escucha iniciada", Toast.LENGTH_SHORT).show();
        } else {
            tvStatus.setText("Detenido");
            tvStatus.setTextColor(getResources().getColor(R.color.gray));
            Toast.makeText(this, "Escucha detenida", Toast.LENGTH_SHORT).show();
        }
    }

    private void toggleNoiseReduction() {
        Toast.makeText(this, "Reducción de ruido activada", Toast.LENGTH_SHORT).show();
    }

    private void toggleBluetooth() {
        Toast.makeText(this, "Bluetooth activado", Toast.LENGTH_SHORT).show();
    }

    private void increaseVolume() {
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if (currentVolume < maxVolume) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, AudioManager.FLAG_SHOW_UI);
        }
    }

    private void decreaseVolume() {
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (currentVolume > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, AudioManager.FLAG_SHOW_UI);
        }
    }
}
