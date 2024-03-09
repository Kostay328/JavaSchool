package ru.progwards.java1.lessons.io2;

public class Translator {
    private String[] inLang;
    private String[] outLang;
    Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }
    public String translate(String sentence){
        String[] sl = sentence.split(" ");
        String res = "";
        try {
            boolean cd;
            for (String word:sl) {
                cd = false;
                for (int i=0; i<inLang.length; i++){
                    String w = word.replaceAll("[^a-zA-Zа]", "");
                    if(w.equals(inLang[i])){
                        res += word.replace(inLang[i], outLang[i]) + " ";
                        cd = true;
                    }else if(w.equals(inLang[i].substring(0, 1).toUpperCase() + inLang[i].substring(1))){
                        res += word.replace(inLang[i].substring(0, 1).toUpperCase() + inLang[i].substring(1), outLang[i].substring(0, 1).toUpperCase() + outLang[i].substring(1)) + " ";
                        cd = true;
                    }
                }
                if(!cd) {
                    res += word + " ";
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return res;
    }
}
