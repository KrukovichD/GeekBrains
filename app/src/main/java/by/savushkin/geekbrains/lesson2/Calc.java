package by.savushkin.geekbrains.lesson2;

import android.os.Parcel;
import android.os.Parcelable;

public class Calc implements Parcelable {
    private String value,
            value2;
    private String visible;
    private String operator;
    private boolean equals;

    public String getVisible() {
        return visible;
    }

    public Calc() {
        visible = value = value2 = operator = "";
        equals = false;
    }

    private String selector(String select) {
        double result;
        switch (select) {
            case "/": {
                try {
                    result = Double.parseDouble(value) / Double.parseDouble(value2);
                } catch (Exception e) {
                    result = 0;
                }
            }
            break;
            case "X": {
                result = Double.parseDouble(value) * Double.parseDouble(value2);
            }
            break;
            case "+": {
                result = Double.parseDouble(value) + Double.parseDouble(value2);
            }
            break;
            case "-": {
                result = Double.parseDouble(value) - Double.parseDouble(value2);
            }
            break;
            case "%": {
                result = Double.parseDouble(value) * Double.parseDouble(value2) / 100;
            }
            break;
            case "C": {
                value = value2 = "";
                visible = "";
                operator = "";
                return visible;
            }
            case "<Del": {
                if (!operator.equals("") && visible.endsWith(operator))
                    operator = "";
                if (!visible.equals("")) {
                    visible = visible.substring(0, visible.length() - 1);
                }
                return visible;
            }
            default: {

                return visible;
            }
        }
        operator = "C";
        selector("C");
        return visible = String.valueOf(result);
    }

    public String numHandler(String numInter) {
        if (equals) {
            visible = "";
            equals = false;
        }
        if ((numInter.equals(".") && !visible.replace(value, "").contains(".")) ||
                !numInter.equals(".")) {
            if (numInter.equals(".") && (visible.equals("") || visible.endsWith("\n")))
                visible += "0";

            visible += numInter;
        }
        return visible;
    }

    public String operHandler(String operInter) {
        equals = false;

        if (operInter.equals("-") && visible.equals("")) {
            visible += operInter;
            return visible;
        }
        if (visible.equals("") || visible.equals("-")) {
            visible = "";
            return visible;
        }

        if (!(operInter.equals("=")
                || operInter.equals("C")
                || operInter.equals("<Del"))) {
            if (operator.equals("")) {
                operator = operInter;
                value = visible;
                visible = visible + "\n" + operator + "\n";
            } else if (visible.endsWith("\n")) {
                operator = operInter;
                visible = visible.substring(0, visible.length() - 2) + operator + "\n";
            } else {
                String operSpare = operInter;
                operHandler("=");
                operHandler(operSpare);
            }
        } else {
            if (!operator.equals("")) {
                if (operInter.equals("=") && !visible.endsWith("\n")) {
                    equals = true;
                    value2 = visible.replace((value + "\n" + operator + "\n"), "");
                    operInter = operator;
                }
            }
            selector(operInter);

        }
        return visible;
    }
    protected Calc(Parcel in) {
        value = in.readString();
        value2 = in.readString();
        visible = in.readString();
        operator = in.readString();
        equals = in.readByte() != 0;
    }

    public static final Creator<Calc> CREATOR = new Creator<Calc>() {
        @Override
        public Calc createFromParcel(Parcel in) {
            return new Calc(in);
        }

        @Override
        public Calc[] newArray(int size) {
            return new Calc[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(value);
        dest.writeString(value2);
        dest.writeString(visible);
        dest.writeString(operator);
        dest.writeByte((byte) (equals ? 1 : 0));
    }
}
