package com.devix.www.recyclerviewselected;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private View btnGo;
    private ArrayList<String> selectedStrings;
    private static final String[] numbers = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid);
        btnGo = findViewById(R.id.btnSelected);
        selectedStrings = new ArrayList<>();

        final GridViewAdapter adapter = new GridViewAdapter(numbers, this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedIndex = adapter.selectedPositions.indexOf(position);

                if (selectedIndex > -1) {
                    adapter.selectedPositions.remove(selectedIndex);
                    ((GridItemView) view).dysplay(false);
                    selectedStrings.add((String) parent.getItemAtPosition(position));
                } else {
                    adapter.selectedPositions.add(position);
                    ((GridItemView) view).dysplay(true);
                    selectedStrings.add((String)parent.getItemAtPosition(position));
                }
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectedItemsActivity.class);
                intent.putStringArrayListExtra("SELECTED_LETTER", selectedStrings);
                startActivity(intent);
            }
        });
    }
}
