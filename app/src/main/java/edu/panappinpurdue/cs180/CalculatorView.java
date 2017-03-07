package edu.panappinpurdue.cs180;

import android.view.View;
import android.widget.TextView;

/**
 * Created by panappin on 12/2/15.
 */
public class CalculatorView implements CalculatorViewInterface {

    private TextView textViewDisplay;


    CalculatorView(View textViewDisplay) {
        this.textViewDisplay = (TextView) textViewDisplay;


    }

    @Override
    public void display(String val) {
        textViewDisplay.setTextKeepState(val);
    }

    @Override
    public void invalid() {
        textViewDisplay.setText("Inv");
    }


}
