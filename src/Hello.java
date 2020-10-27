import java.util.ArrayList;


public class Hello {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add("Hello");
        String txt = list.get(0).toString();
        System.out.println(txt);

    }

    public static void tstJ(){
        System.out.println("Hello JAVA public static!");
    }
}
