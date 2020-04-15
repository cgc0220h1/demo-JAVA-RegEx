import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^abc");
        System.out.println(pattern.matcher("abcdef").matches());
        String demo = "abcdef";
    }
}
