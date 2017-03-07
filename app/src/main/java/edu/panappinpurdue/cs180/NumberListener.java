package edu.panappinpurdue.cs180;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by panappin on 12/2/15.
 */
public class NumberListener implements View.OnClickListener {
    View view;
    Calculator calculator;
    char number;
    static boolean flag;

    NumberListener(Calculator calculator, char number) {
        this.calculator = calculator;
        this.number = number;
    }

    @Override
    public void onClick(View view) {
        flag = !flag;
        this.view = view;
        setColor();
        calculator.inputDigit(number);
    }

    public void setColor() {
        MainActivity.changeColor();
        view.setBackgroundColor(Color.rgb(0, 255, 127));

    }

    public View getView() {
        return view;
    }
}
