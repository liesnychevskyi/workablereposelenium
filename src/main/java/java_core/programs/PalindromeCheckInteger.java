package java_core.programs;

public class PalindromeCheckInteger
{
    public static void main(String args[])
    {
        int n = 4554;  //It is the number variable to be checked for palindrome
        int r;
        int sum = 0;
        int temp;

        temp = n;

        while(n > 0)
        {
            r = n % 10;     //getting remainder
            System.out.println("Percent from dividing is: " + r);
            sum = (sum * 10) + r;
            System.out.println("Sum is: " + sum);
            n = n / 10;
        }
        if(temp == sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }
}
