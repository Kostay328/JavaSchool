package ru.progwards.java1.lessons.params;

public class FloatNumber {
    boolean sign;
    long mantissa;
    int exp;

    public FloatNumber(boolean sign, long mantissa, int exp) {
        this.sign = sign;
        this.mantissa = mantissa;
        this.exp = exp;
    }

    FloatNumber(String num){
        num = num.trim().replace(",", "").replace(".", "");
        char[] cl = num.toCharArray();
        if(cl[0] == '-')
            sign = false;
        else
            sign = true;
        String r = "";
        String r0 = "";
        for (int i = sign ? 0 : 1; i < cl.length; i++){
            if(Character.isDigit(cl[i]))
                r += cl[i];
            else {
                for (int j = i+1; j < cl.length; j++){
                    r0 += cl[j];
                }
                break;
            }
        }
        mantissa = Long.getLong(r);
        exp = Integer.getInteger(r0);
    }

    @Override
    public String toString() {
        String res = "";
        if(!sign)
            res += "-";
        char[] cl = Long.toString(mantissa).toCharArray();
        res += cl[0] + ".";
        for (int i = 2; i < cl.length; i++){
            res += cl[i];
        }
        if(exp > 0) {
            res += "E" + exp;
        }
        return res;
    }

    double toDouble(){
        return Double.parseDouble(this.toString());
    }

    void fromDouble(double num){

    }

    void negative(){

    }

    FloatNumber add(FloatNumber num){
        return null;
    }

    FloatNumber sub(FloatNumber num){
        return null;
    }

    public static void main(String[] args) {

    }
}
