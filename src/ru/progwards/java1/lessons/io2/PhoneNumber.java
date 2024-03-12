package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone) throws Exception {
        String res = "";
        String[] sl = phone.split("");
        int i = 0;
        for (String s:sl) {
            if(s.matches("[-+]?\\d+")){
                if(i==0)
                    res+="+7";
                else {
                    if(i==1)
                        res+="(";
                    if(i==4)
                        res+=")";
                    if(i==7)
                        res+="-";
                    res += s;
                }
                i++;
            }
        }

        if(res.length() != 1 && res.length() != 1)
            throw new Exception("Длинна номера неверная");

        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(format("- 8 (999) 1 1 1 -2 2 -3 3"));
    }
}
