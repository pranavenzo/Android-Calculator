package edu.panappinpurdue.cs180;

import android.graphics.Color;
import android.view.View;

/**
 * Created by panappin on 12/2/15.
 */
public class DotListener implements View.OnClickListener {
    View view;
    Calculator calculator;

    DotListener(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void onClick(View view) {
        this.view = view;
        setColor();
        calculator.dot();
    }

    public void setColor() {
        MainActivity.changeColor();
        view.setBackgroundColor(Color.rgb(0, 191, 255));


    }


    public View getView() {
        return view;
    }

}
