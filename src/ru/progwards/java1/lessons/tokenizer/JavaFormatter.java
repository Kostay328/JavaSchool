package ru.progwards.java1.lessons.tokenizer;

import java.util.StringTokenizer;

public class JavaFormatter {
    public static String format(String code){
        String ress = "";
//         code = "public static void main(String[] args)\n" +
//                "{\n" +
//                "System.out.println(\"Enter two numbers\");\n" +
//                "int first = 10;" +
//                "int second = 20;\n" +
//                "System.out.println(first + \" \" + second);\n" +
//                "int sum = first + second;\n" +
//                "System.out.println(\"The sum is: \" + sum);\n" +
//                "  }";
         code = code.replaceAll("  "," ");
         String[] res = new String[code.length()];
         StringTokenizer st = new StringTokenizer(code, "{}\n", true);
         int teg = 0;
         for (int i = 0; st.hasMoreTokens(); i++){
             res[i] = st.nextToken();
             if(res[i].contains("{")){
                 res[i-1] = res[i-1].replace("\n", " ");
                 teg++;
             }
             if(res[i].contains("}")){
                 res[i] = res[i].replace(" ","");
                 teg--;
             }
             if(teg > 0 && !res[i].contains("}") && !res[i].contains("{") && res[i].contains(";")) {
                 String spaces = "";
                 for (int j = 0; j < teg; j++)
                     spaces += "    ";
                 res[i] = spaces + res[i];
             }
         }
        for (String rl:res) {
            if(rl == null)
                break;
            ress += rl;
        }
        return ress.replaceAll(" }","}");
    }

    public static void main(String[] args) {
        System.out.println(format(""));
    }
}
