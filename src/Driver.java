import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // "\(([0-9]*| -)[A-z]\+[0-9]*\)\^(1*[0-9])"
        // Pattern p = Pattern.compile("\\(([0-9]*| -)[A-z]\\+[0-9]*\\)\\^(1*[0-9])");


        System.out.println("Input a binomial in the form (ax+b)^n");
        System.out.println("n must be an integer less than 13 and greater than -1");
        System.out.println("x may be replaced with any letter");
        String input = sc.nextLine();
        // Matcher m = p.matcher(input);
        // while (!m.find()) {
        //     System.out.println("Input a binomial in the form (ax+b)^n");
        //     System.out.println("n must be an integer less than 13 and greater than -1");
        //     input = sc.nextLine();
        // }
        Expand e = new Expand(input);
        System.out.println("\n" + e);
    }
}