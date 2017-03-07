package edu.panappinpurdue.cs180;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;


public class MainActivity extends Activity {
    private static Button button0;
    private static Button button1;
    private static Button button2;
    private static Button button3;
    private static Button button4;
    private static Button button5;
    private static Button button6;
    private static Button button7;
    private static Button button8;
    private static Button button9;
    private static Button buttonDel;
    private static Button buttonAdd;
    private static Button buttonSubtract;
    private static Button buttonDiv;
    private static Button buttonMult;
    private static Button buttonDot;
    private static Button buttonEqual;
    public static Drawable d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Extract the view elements

        // Create view
        CalculatorView view = new CalculatorView(findViewById(R.id.textViewDisplay));
        Calculator calculator = new Calculator(view);
        button0 = (Button) (findViewById(R.id.buttonZero));
        button0.setOnClickListener(new NumberListener(calculator, '0'));
        d = button0.getBackground();
        button1 = (Button) (findViewById(R.id.buttonOne));
        button1.setOnClickListener(new NumberListener(calculator, '1'));
        button2 = (Button) (findViewById(R.id.buttonTwo));
        button2.setOnClickListener(new NumberListener(calculator, '2'));
        button3 = (Button) (findViewById(R.id.buttonThree));
        button3.setOnClickListener(new NumberListener(calculator, '3'));
        button4 = (Button) (findViewById(R.id.buttonFour));
        button4.setOnClickListener(new NumberListener(calculator, '4'));
        button5 = (Button) (findViewById(R.id.buttonFive));
        button5.setOnClickListener(new NumberListener(calculator, '5'));
        button6 = (Button) (findViewById(R.id.buttonSix));
        button6.setOnClickListener(new NumberListener(calculator, '6'));
        button7 = (Button) (findViewById(R.id.buttonSeven));
        button7.setOnClickListener(new NumberListener(calculator, '7'));
        button8 = (Button) (findViewById(R.id.buttonEight));
        button8.setOnClickListener(new NumberListener(calculator, '8'));
        button9 = (Button) (findViewById(R.id.buttonNine));
        button9.setOnClickListener(new NumberListener(calculator, '9'));

        buttonDel = (Button) (findViewById(R.id.buttonDel));
        buttonDel.setOnClickListener(new DeleteListener(calculator));

        buttonAdd = (Button) (findViewById(R.id.buttonAdd));
        buttonAdd.setOnClickListener(new OperationListener(calculator, '+'));
        buttonSubtract = (Button) (findViewById(R.id.buttonSubtract));
        buttonSubtract.setOnClickListener(new OperationListener(calculator, '-'));
        buttonDiv = (Button) (findViewById(R.id.buttonDiv));
        buttonDiv.setOnClickListener(new OperationListener(calculator, '/'));
        buttonMult = (Button) (findViewById(R.id.buttonMult));
        buttonMult.setOnClickListener(new OperationListener(calculator, '*'));

        buttonDot = (Button) (findViewById(R.id.buttonDot));
        buttonDot.setOnClickListener(new DotListener(calculator));

        buttonEqual = (Button) (findViewById(R.id.button2));
        buttonEqual.setOnClickListener(new EqualListener(calculator));

        int colorFrom = 0xaaaaaaaa;
        int colorTo = 0xffFFFFFF;
        int duration = 1000;
        ObjectAnimator anim = ObjectAnimator.ofObject(button0, "backgroundColor", new ArgbEvaluator(), colorFrom, colorTo);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Trigger the events after animation is ended
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        anim.setDuration(duration).start();


    }


    public static void changeColor() {
        button0.setBackgroundDrawable(d);
        button1.setBackgroundDrawable(d);
        button2.setBackgroundDrawable(d);
        button3.setBackgroundDrawable(d);
        button4.setBackgroundDrawable(d);
        button5.setBackgroundDrawable(d);
        button6.setBackgroundDrawable(d);
        button7.setBackgroundDrawable(d);
        button8.setBackgroundDrawable(d);
        button9.setBackgroundDrawable(d);
        buttonAdd.setBackgroundDrawable(d);
        buttonSubtract.setBackgroundDrawable(d);
        buttonDel.setBackgroundDrawable(d);
        buttonDiv.setBackgroundDrawable(d);
        buttonDot.setBackgroundDrawable(d);
        buttonEqual.setBackgroundDrawable(d);
        buttonMult.setBackgroundDrawable(d);
        button0.setBackgroundDrawable(d);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
