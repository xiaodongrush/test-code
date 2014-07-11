package com.example.fonttest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
    private String[] fontName;

    private String[] fontAssestPath;

    private ListView mListView;

    private ArrayAdapter mAdapter;

    private TextView mTestFontTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        fontName = getResources().getStringArray(R.array.font_names);
        fontAssestPath = new String[] {
            "font-file/HYZhuanShuF.font", "font-file/HYShouJinShuJ.font",
            "font-file/HYNanGongJ.font", "font-file/LTHYSZK.font"
        };
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.list);
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                fontName);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        mTestFontTv = (TextView) findViewById(R.id.testTxt);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        mTestFontTv.setTypeface(getTypeFace(position));
    }

    private Typeface getTypeFace(int position) {
        if (position == 0) {
            return Typeface.DEFAULT;
        } else {
            return Typeface.createFromAsset(getAssets(),
                    fontAssestPath[position - 1]);
        }
    }

}
