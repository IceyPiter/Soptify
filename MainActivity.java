package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;
    private String[] itens = {
            "Borboletas\nVitor e Léo","Aonde quer que eu vá\nParalamas do Sucesso",
            "Aonde quer que eu vá\nParalamas do Sucesso","Aonde quer que eu vá\nParalamas do Sucesso",
            "Aonde quer que eu vá\nParalamas do Sucesso","Aonde quer que eu vá\nParalamas do Sucesso",
            "I Don't Want to be","Goldberg Variations"
    };
    private Integer contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tituloMusic = findViewById(R.id.titulo);
        ImageView imagem = findViewById(R.id.imageMusic);

        String music = itens[0];
        tituloMusic.setText(music);
        imagem.setImageResource(R.drawable.borboletas);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music1);
        inicializarSeekBar();
    }
//    @Override
//    protected void onStop(){
//        super.onStop();
//        if(mediaPlayer.isPlaying()){
//            mediaPlayer.pause();
//        }
//    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void inicializarSeekBar() {
        seekVolume = findViewById(R.id.seekVolume);
        //configurar Volume
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Recuperar Volume Maximo e atual
        int volumeMaximo = audioManager.getStreamMaxVolume((AudioManager.STREAM_MUSIC));
        int volumeAtual = audioManager.getStreamVolume((AudioManager.STREAM_MUSIC));
        seekVolume.setMax(volumeMaximo);
        seekVolume.setProgress(volumeAtual);
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void executarSom(View view){
        if (mediaPlayer!=null){
            mediaPlayer.start();
        }
    }

    public void pausarMusica(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void pararMusica(View view){
        if (mediaPlayer.isPlaying()){
            if (contador == 0) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music1);

            } else if (contador == 1) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music2);

            } else if (contador == 2) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music3);
            }

            else if (contador == 3) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music4);
            }

            else if (contador == 4) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music5);
            }

            else if (contador == 5) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music6);
            }

            else if (contador == 6){
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.teste);
            }

            else if (contador == 7) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bach);
            }
        }
    }

    public void mudarTítulo(int cont){
        TextView tituloMusic = findViewById(R.id.titulo);
        ImageView imagem = findViewById(R.id.imageMusic);

        if(cont == 0){
            imagem.setImageResource(R.drawable.borboletas);
        }
        if(cont == 1){
            imagem.setImageResource(R.drawable.aonde);
        }

        String music = itens[cont];
        tituloMusic.setText(music);
    }

    public void nextMusic(View view) {
        if (contador == 0) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music1);
            mediaPlayer.start();
            mudarTítulo(0);

        } else if (contador == 1) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);
            mediaPlayer.start();
            mudarTítulo(1);

        } else if (contador == 2) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music3);
            mediaPlayer.start();
            mudarTítulo(2);
        }

        else if (contador == 3) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music4);
            mediaPlayer.start();
            mudarTítulo(3);
        }

        else if (contador == 4) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music5);
            mediaPlayer.start();
            mudarTítulo(4);
        }

        else if (contador == 5) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music6);
            mediaPlayer.start();
            mudarTítulo(5);
        }

        else if (contador == 6){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
            mediaPlayer.start();
            mudarTítulo(6);
        }

        contador += 1;

        if (contador == 7) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bach);
            contador = 0;
            mediaPlayer.start();
            mudarTítulo(7);
        }
    }
}