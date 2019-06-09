package android.lifeistech.clap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

// 手拍子のクラス
public class Clap {
    // 音楽プレイヤー
    private SoundPool soundPool;
    // 読み込んだ音声のID
    private int soundId;

    public Clap(Context context){
        // SoundPoolインスタンスの生成
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(context, R.raw.clap, 1);
    }

    // 音楽再生メソッド
    public void play(){
        soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    // 複数回再生メソッド
    public void repeatPlay(int repeat){
        int count = 0;

        // Repeatの数だけ再生する
        while(count < repeat){
            play();
            count++;
            // 一回鳴らすごとに0.5s待機
            try{
                Thread.sleep(500);
            // エラー発生時スタックトレース
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
