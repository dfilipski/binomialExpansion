import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expand {
    private int a;
    private int b;
    private int n;
    private char x;
    private String output;
    
    public Expand(String input) {
        output = "";
        a = getA(input);
        x = getX(input);
        b = getB(input);
        n = getN(input);
        expand();
    }
    
    private Integer getA(String input) {
        int a;
        Pattern p = Pattern.compile("[A-z]");
        Matcher m = p.matcher(input);
        
        if (!m.find()) {
            return null;
        }
        int xIndex = m.start();
        if (xIndex == 1) {
            return 1;
        } else if (xIndex == 2 && input.charAt(1) == '-') {
            return -1;
        } else {
            a = Integer.parseInt(input.substring(1,xIndex));
            return a;
        }
    }
    
    private char getX(String input) {
        Pattern p = Pattern.compile("[A-z]");
        Matcher m = p.matcher(input);
        if (!m.find()) {
            return '~';
        } else {
            return input.charAt(m.start());
        }
    }
    
    private int getB(String input) {
        int start = input.indexOf("+");
        if (start == -1)
            start = input.indexOf("-") - 1;
        int b = Integer.parseInt(input.substring(start + 1, input.indexOf(")")));
        return b;
    }
    
    private int getN(String input) {
        if (input.indexOf("^") == -1)
            return 1;
        int n = Integer.parseInt(input.substring(input.indexOf("^") + 1));
        return n;
    }
    
    private void expand() {
        for (int i = n; i >= 0; --i) {
            int coef = binomCoef(n,i)*((int) Math.pow(a,i))*((int) Math.pow(b, (n-i)));
            if (coef < 0) {
                output = output.substring(0, output.length() - 2) + "- ";
                coef *= -1;
            }
            output += coef;
            if (i == 0) {
                output += " + ";   
            } else if (i == 1) {
                output += x + " + ";
            }else {
                output += x +"^" + i + " + ";
            }
        }
    }
    
    private int binomCoef(int n, int k) {
        return (factorial(n))/ (factorial(k) * factorial(n-k));
    }
    
    private int factorial (int n) {
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 
                362880, 3628800, 39916800, 479001600};
        return fact[n];
    }
    
    public String toString() {
        return output.substring(0, output.length() - 2);
    }
}
