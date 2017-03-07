package edu.panappinpurdue.cs180;

import android.graphics.Color;
import android.view.View;

/**
 * Created by panappin on 12/2/15.
 */
public class DeleteListener implements View.OnClickListener {
    View view;
    Calculator calculator;

    DeleteListener(Calculator calculator) {
        this.calculator = calculator;

    }

    @Override
    public void onClick(View view) {
        this.view = view;
        setColor();
        calculator.delete();
    }

    public void setColor() {
        MainActivity.changeColor();
        view.setBackgroundColor(Color.RED);

    }

    public View getView() {
        return view;
    }
}
