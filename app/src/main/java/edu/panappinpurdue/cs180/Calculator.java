

package edu.panappinpurdue.cs180;

/**
 * Created by panappin on 12/4/15.
 */
public class Calculator {
    CalculatorViewInterface view;
    String method;
    String input;
    char operator;
    String result;
    int decimalCount;
    boolean invalid;
    int digs;
    boolean infinity;

    public Calculator(CalculatorViewInterface view) {
        this.view = view;
        method = null;
        input = "";
        operator = ' ';
        result = "";
        decimalCount = 0;
        invalid = false;
        digs = 0;
        infinity = false;
    }

    public void inputDigit(char act) {
        int digsAfterDecimal = 0;
        String in = input;
        for (int i = in.indexOf('.') + 1; i < in.length(); i++) {
            if (i == 0) {
                break;
            }
            if (Character.isDigit(in.charAt(i))) {
                digsAfterDecimal++;
            } else if (in.charAt(i) == operator) {
                digsAfterDecimal = 0;
                String s = in;
                in = in.substring(i);
                i = s.substring(i).indexOf('.');

                if (i == -1) {
                    break;
                }
            }
        }
        if (digsAfterDecimal == 2) {
            method = "inp";
            invalid = true;
            view.invalid();
            return;
        }
        if (operator == '/' && (input.charAt(input.length() - 1) != '/') && Double.parseDouble(input.split("/")[1]) == '0') {
            method = "inp";
            invalid = true;
            view.invalid();
            return;
        }


        if ((method != null && method.equals("equal") && !invalid) || infinity) {
            input = "";
            operator = ' ';
            digs = 0;
            decimalCount = 0;
            infinity = false;

        }
        if ((method != null) && method.equals("equal") && invalid && operator != ' ') {
            input = result;
        }
        if (method != null && method.equals("op") && act == '0') {
            //infinity = true;
        }
        input += act;
        if ((method != null && method.equals("dot")) || digs != 0) {
            digs++;
        }

        method = "inp";
        print(input);
        invalid = false;
    }

    public void equal() {
        if ((input.length() > 0) && (method == null || method.equals("op")
                || input.charAt(input.length() - 1) == '.')) {
            invalid = true;
            view.invalid();
            return;
        }

        method = "equal";
        int operatorIndex = input.indexOf(operator);
        if (operatorIndex == -1 || operatorIndex == input.length() - 1) {
            invalid = true;
            view.invalid();
            return;
        }
        String number1 = input.substring(0, operatorIndex);
        String number2 = input.substring(operatorIndex + 1);
        switch (operator) {
            case ('+'):
                result = Double.parseDouble(number1) + Double.parseDouble(number2) + "";
                break;
            case ('-'):
                result = Double.parseDouble(number1) - Double.parseDouble(number2) + "";
                break;
            case ('*'):
                result = Double.parseDouble(number1) * Double.parseDouble(number2) + "";
                break;
            case ('/'): {
                if (Double.parseDouble(number2) == 0) {
                    invalid = true;
                    infinity = true;
                    view.display(Double.parseDouble(number1) / Double.parseDouble(number2) + "");
                    return;
                }
                result = Double.parseDouble(number1) / Double.parseDouble(number2) + "";
                break;
            }
            default: {
                invalid = true;
                view.invalid();
                return;
            }


        }
        invalid = false;
        int x = (int) (Double.parseDouble(result) * 100);
        if (Math.abs(Double.parseDouble(result) * 100 - x) > 0.5) {
            x += 1;
        }
        result = (x / 100.0) + "";
        if (result.charAt(result.length() - 2) == '.') {
            result += '0';
        }
        print(result);


    }

    public void delete() {
        if (input.length() > 0 && input.charAt(input.length() - 1) == operator && !invalid) {
            operator = ' ';
        }
        if (input.length() > 0 && !(method.equals("equal")) && !invalid) {
            input = input.substring(0, input.length() - 1);
        }
        if (infinity || input.length() == 0) {
            input = "";
            operator = ' ';
            digs = 0;
            decimalCount = 0;
            infinity = false;
        }
        print(input);
        method = "delete";
        invalid = false;
    }


    public void dot() {
        if (input.length() == 0 || method == null || method.equals("dot")
                || method.equals("equal") || input.charAt(input.length() - 1) == operator) {
            invalid = true;
            view.invalid();
            return;
        }
        int deci = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                deci++;
            } else if (input.charAt(i) == operator) {
                deci = 0;
            }
        }
        if (deci >= 1) {
            invalid = true;
            view.invalid();
            return;

        }
        method = "dot";
        input += '.';
        decimalCount++;
        print(input);

    }

    public void operator(char op) {
        if (input.length() == 0) {
            invalid = true;
            view.invalid();
            return;
        }
        if ((method != null) && method.equals("equal")) {
            input = result;
            operator = ' ';
        }
        if (operator == '/' && input.charAt(input.length() - 1) == '0') {
            invalid = true;
            view.invalid();
            return;

        }
        if ((method != null) && input.charAt(input.length() - 1) == operator) {
            input = input.substring(0, input.length() - 1);
        } else if (operator != ' ') {
            invalid = true;
            view.invalid();
            return;

        }

        if (infinity) {
            input = "";
            operator = ' ';
            digs = 0;
            decimalCount = 0;
            infinity = false;
            operator(operator);
            return;
        }
        operator = op;
        input = input + operator;
        method = "op";
        decimalCount = 0;
        digs = 0;
        print(input);


    }

    public void print(String input) {
        int operatorIndex = input.indexOf(operator);
        if (operatorIndex == -1) {
            view.display(input);
            return;
        }
        String a = input.substring(0, operatorIndex);
        String b = input.substring(operatorIndex + 1);

        view.display(a + " " + operator + " " + b);


    }

}
