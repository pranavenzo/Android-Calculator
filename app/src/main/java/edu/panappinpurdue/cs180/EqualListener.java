package edu.panappinpurdue.cs180;

import android.graphics.Color;
import android.view.View;

/**
 * Created by panappin on 12/2/15.
 */
public class EqualListener implements View.OnClickListener {
    View view;
    Calculator calculator;

    EqualListener(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void onClick(View view) {
        this.view = view;
        setColor();
        calculator.equal();
    }

    public void setColor() {
        MainActivity.changeColor();
        view.setBackgroundColor(Color.rgb(127, 255, 0));
    }


}
