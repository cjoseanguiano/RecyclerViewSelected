package com.devix.www.recyclerviewselected;
/*
 *Created by Carlos Anguiano on 13/04/17.
 *For more info contact : c.joseanguiano@gmail.com
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class GridItemView extends FrameLayout {
    private TextView textView;

    public GridItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_grid, this);
        textView = (TextView) getRootView().findViewById(R.id.txtTexto);
    }

    public void dysplay(String text, boolean isSelected) {
        textView.setText(text);
        dysplay(isSelected);
    }

    public void dysplay(boolean isSelected) {
        textView.setBackgroundResource(isSelected ? R.color.colorAccent : R.color.colorPrimary);
    }
}
