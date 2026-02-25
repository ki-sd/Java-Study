package testPjt_String;

public class MainClass {
    public static void main(String[] args) {

        String str = "JAVA";
        System.out.println("str = " + str);
        str = str + "_8";
        System.out.println("str = " + str);

        //StringBuffer
        StringBuffer sf = new StringBuffer("JAVA");
        System.out.println("sf = " + sf);
        sf.append("World");
        System.out.println("sf = " + sf);
        System.out.println("sf.length = " + sf.length());
        sf.insert(sf.length(), "~~~~");
        System.out.println("sf = " + sf);

        sf.delete(9, 13);
        System.out.println("sf = " + sf);

        //StringBuilder
        StringBuilder sb = new StringBuilder("JAVA");
        System.out.println("sb = " + sb);
        sb.append("World");
        System.out.println("sb = " + sb);
    }
}
