import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fang on 2016/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] str=new String[3];

            ArrayList<Integer> list=new ArrayList<Integer>();
            Integer a=0;
            str[0]=scanner.nextLine();
            str[1]=scanner.nextLine();
            str[2]=scanner.nextLine();

            for(int i=0;i<str[1].length();i++){

                a=str[0].indexOf( str[1].charAt(i),a);
                list.add(a);
                a=a+1;
                System.out.println("xunhuan1"+a);
            }
            for(int i=0;i<str[2].length();i++){
                System.out.println(a);
                a=str[0].indexOf(str[1].charAt(i),a);
                list.add(a);
                a=a+1;
                System.out.println("xunhuan2"+a);
            }
        System.out.println(list);
            if(islist1(list)&&islist2(list))
                System.out.println("both");
            else if(islist1(list))
                System.out.println("forward");
            else if(islist2(list))
                System.out.println("backward");
            else
                System.out.println("invalid");


    }
    public static boolean islist1(ArrayList<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(0)<list.get(i+1)){

            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean islist2(ArrayList<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(0)>list.get(i+1)){

            }else{
                return false;
            }
        }
        return true;
    }
}
