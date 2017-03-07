package edu.panappinpurdue.cs180;

import android.graphics.Color;
import android.view.View;

import javax.crypto.spec.OAEPParameterSpec;

/**
 * Created by panappin on 12/2/15.
 */
public class OperationListener implements View.OnClickListener {
    View view;
    Calculator calculator;
    char operation;
    int c;

    OperationListener(Calculator calculator, char operation) {
        this.calculator = calculator;
        this.operation = operation;
        c = Color.GRAY;
    }

    @Override
    public void onClick(View view) {
        this.view = view;
        calculator.operator(operation);
        setColor();

    }

    public void setColor() {
        MainActivity.changeColor();
        view.setBackgroundColor(Color.rgb(0, 255, 255));

    }


    public int getColor() {
        return c;

    }
}
