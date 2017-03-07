package edu.panappinpurdue.cs180;

/**
 * Created by panappin on 12/2/15.
 */
public class Calculator2 {
    String number1;
    String number2;
    String result;
    char operator;
    String runningInput;
    String trailing;
    CalculatorViewInterface view;
    int dotCount;
    int dec;

    public Calculator2(CalculatorViewInterface view) {
        this.view = view;
        number1 = "";
        number2 = "";
        result = "";
        runningInput = "";
        dotCount = 0;
        operator = ' ';
        dec = 0;
        trailing = "";
    }

    public void inputDigit(char act) {
        if ((!(result.equals(""))) && (runningInput.equals(trailing))) {
            result = "";
            if (runningInput.equals("")) {
                operator = ' ';//should become last operator!!!!!!!!
            }
            dotCount = 0;
        }
        boolean f = true;

        if (!(runningInput.length() <= 0)) {
            String[] arr = runningInput.split("");
            for (int i = 1; i <= runningInput.length(); i++) {
                if (arr[i].equals(".")) {
                    dec = 0;
                    for (int j = i + 1; j <= runningInput.length(); j++) {
                        if (arr[j].equals(operator + "")) {
                            f = false;
                            break;

                        } else {
                            dec++;
                        }

                    }
                    if (dec >= 2 && f) {
                        trailing = runningInput;
                        view.invalid();
                        return;
                    }
                    dec = 0;
                }
            }
        }
        trailing = runningInput;
        runningInput += act;
        view.display(runningInput);


    }

    public void equal() {
        trailing = runningInput;
        int operatorIndex = runningInput.indexOf(operator);
        if (operatorIndex == -1) {
            view.invalid();
            return;
        }
        if (operatorIndex == runningInput.length() - 1) {
            view.invalid();
            return;
        }
        number1 = runningInput.substring(0, operatorIndex);
        number2 = runningInput.substring(operatorIndex + 1);

        switch (operator) {
            case ('+'):
                result = Double.parseDouble(number1) + Double.parseDouble(number2) + "";
                break;
            case ('-'):
                result = Double.parseDouble(number1) - Double.parseDouble(number2) + "";
                break;
            case ('x'):
                result = Double.parseDouble(number1) * Double.parseDouble(number2) + "";
                break;
            case ('/'): {
                if (Double.parseDouble(number2) == 0) {
                    view.display(Double.parseDouble(number1) == 0 ? "NaN" : Double.parseDouble(number1) < 0 ? "-Infinity" : "Infinity");
                    return;
                }
                result = Double.parseDouble(number1) / Double.parseDouble(number2) + "";
                break;
            }
            default:
                view.invalid();


        }
        int x = (int) (Double.parseDouble(result) * 100);
        if (Math.abs(Double.parseDouble(result) * 100 - x) > 0.5) {
            x += 1;
        }
        result = (x / 100.0) + "";
        view.display(result);

    }

    public void delete() {

        if (runningInput.length() > 1 && runningInput.charAt(runningInput.length() - 1) == operator) {
            operator = ' ';
        }
        if (runningInput.charAt(runningInput.length() - 1) == '.') {
            dotCount--;
        }
        result = "";


        runningInput = trailing;
        view.display(runningInput);
    }

    public void dot() {

        if (runningInput.charAt(runningInput.length() - 1) == '.') {
            runningInput = runningInput.substring(0, runningInput.length() - 1);
        } else {
            trailing = runningInput;
            dotCount++;
        }

        if (dotCount <= 1) {
            runningInput = runningInput + ".";
            view.display(runningInput);
        } else {
            view.invalid();
        }

    }

    public void operator(char op) {
        if (!(result.equals(""))) {
            runningInput = result;
            result = "";
            if ((runningInput.equals(""))) {
                operator = ' ';
            }
        }
        if (!Character.isDigit(runningInput.charAt(runningInput.length() - 1))
                && runningInput.charAt(runningInput.length() - 1) != '.') {
            runningInput = runningInput.substring(0, runningInput.length() - 1);
        } else if (operator != ' ') {
            runningInput = trailing;
            view.invalid();
            return;
        }
        trailing = runningInput;
        runningInput = runningInput + op;
        operator = op;
        dotCount = 0;
        view.display(runningInput);


    }

}