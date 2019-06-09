package android.lifeistech.clap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    ImageButton button;
    Clap clapInstance;
    Spinner spinner;
    // 繰り返し数を格納する変数
    int repeat = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 結びつけ
        button = findViewById(R.id.imgBtn);
        button.setOnClickListener(this);
        spinner = findViewById(R.id.spinner);
        // なぜか画像が読み込まれないのでここで設定
        button.setImageResource(R.drawable.button);

        // 手拍子音のインスタンス生成
        clapInstance = new Clap(this.getApplicationContext());

        // Spinnerのリスト用文字列
        String[] strArray = {"パンッ！", "パンパンッ！", "パンパンパンッ！", "4回", "5回"};

        // Spinnerに文字列セット
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, strArray
        );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // スピナーが選択された時
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v){
        clapInstance.repeatPlay(repeat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        repeat = pos + 1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
