package java_core.practice;

public class Constructor
{
        String name;

        //Constructor
        Constructor()
        {
            this.name = "BeginnersBook.com";
        }
        public static void main(String[] args)
        {
            Constructor obj = new Constructor();
            System.out.println(obj.name);
        }
    }

