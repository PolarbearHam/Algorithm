import java.util.ArrayList;
import java.util.Collections;

public class seat {
    
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("강권우");
        list.add("고명진");
        list.add("곽민주");
        list.add("권성은");
        list.add("권예나");
        list.add("김대희");
        list.add("김민식");
        list.add("김우남");
        list.add("박상우");
        list.add("성다연");
        list.add("손예지");
        list.add("손유빈");
        list.add("송수현");
        list.add("안태윤");
        list.add("윤상빈");
        list.add("이상혁");
        list.add("이연수");
        list.add("이유경");
        list.add("정근욱");
        list.add("조원재");
        list.add("한원석");
        list.add("함형준");
        
        Collections.shuffle(list);
        
        System.out.println(" 교수님 \t--------------");
        System.out.printf(" %s %s %s \t %s %s %s \n", list.get(0),  list.get(1),  list.get(2),  "웹엑스",     list.get(3),  list.get(4));
        System.out.printf(" %s %s %s \t %s %s %s \n", list.get(5),  list.get(6),  list.get(7),  list.get(8),  list.get(9),  list.get(10));
        System.out.printf(" %s %s %s \t %s %s %s \n", list.get(11), list.get(12), list.get(13), list.get(14), list.get(15), list.get(16));
        System.out.printf(" %s %s %s \t %s %s %s \n", list.get(17), list.get(18), list.get(19), list.get(20), list.get(21), "");
        
    }

}