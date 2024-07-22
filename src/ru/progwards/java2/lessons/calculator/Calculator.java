package ru.progwards.java2.lessons.calculator;

public class Calculator {
    public static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int calculate(String expression){
        String res = expression;
        while(true) {
            int multiple = res.indexOf('*');
            int divide = res.indexOf('/');
            int plus = res.indexOf('+');
            int minus = res.indexOf('-');

            String[] sl = res.split("");
            if(divide>0 && (divide<multiple || multiple < 0)) {
                String preNum="";
                int ind = divide;
                while(true){
                    --ind;
                    if(ind >= 0 && ind <= sl.length && isInteger(sl[ind]))
                        preNum=sl[ind]+preNum;
                    else
                        break;
                }
                String postNum="";
                int indL = divide;
                while(true){
                    ++indL;
                    if(indL >= 0 && indL < sl.length && isInteger(sl[indL]))
                        postNum=postNum+sl[indL];
                    else
                        break;
                }

                String s = preNum+sl[divide]+postNum;
                int ires = Integer.parseInt(preNum)/Integer.parseInt(postNum);
                res = res.replace(s, ires+"");
            }else if(multiple>0 && (multiple<divide || divide < 0)) {
                String preNum="";
                int ind = multiple;
                while(true){
                    --ind;
                    if(ind >= 0 && ind <= sl.length && isInteger(sl[ind]))
                        preNum=sl[ind]+preNum;
                    else
                        break;
                }
                String postNum="";
                int indL = multiple;
                while(true){
                    ++indL;
                    if(indL >= 0 && indL < sl.length && isInteger(sl[indL]))
                        postNum=postNum+sl[indL];
                    else
                        break;
                }

                String s = preNum+sl[multiple]+postNum;
                int ires = Integer.parseInt(preNum)*Integer.parseInt(postNum);
                res = res.replace(s, ires+"");
            } else if(plus>0 && (plus<minus || minus < 0)) {
                String preNum="";
                int ind = plus;
                while(true){
                    --ind;
                    if(ind >= 0 && ind <= sl.length && isInteger(sl[ind]))
                        preNum=sl[ind]+preNum;
                    else
                        break;
                }
                String postNum="";
                int indL = plus;
                while(true){
                    ++indL;
                    if(indL >= 0 && indL < sl.length && isInteger(sl[indL]))
                        postNum=postNum+sl[indL];
                    else
                        break;
                }

                String s = preNum+sl[plus]+postNum;
                int ires = Integer.parseInt(preNum)+Integer.parseInt(postNum);
                res = res.replace(s, ires+"");
            } else if(minus>0 && (minus<plus || plus < 0)) {
                String preNum="";
                int ind = minus;
                while(true){
                    --ind;
                    if(ind >= 0 && ind <= sl.length && isInteger(sl[ind]))
                        preNum=sl[ind]+preNum;
                    else
                        break;
                }
                String postNum="";
                int indL = minus;
                while(true){
                    ++indL;
                    if(indL >= 0 && indL < sl.length && isInteger(sl[indL]))
                        postNum=postNum+sl[indL];
                    else
                        break;
                }

                String s = preNum+sl[minus]+postNum;
                int ires = Integer.parseInt(preNum)-Integer.parseInt(postNum);
                res = res.replace(s, ires+"");
            }  else
                return Integer.parseInt(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+8/4*5+6"));
    }
}
