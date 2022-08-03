import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();

        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash = "";
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                hasValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }


        }while(!hasValue);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        String trash = "";
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                hasValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }


        }while(!hasValue);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retRangedInt = 0;
        String trash = "";
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: " );
            if(pipe.hasNextInt())
            {
                retRangedInt = pipe.nextInt();
                if(retRangedInt >= low && retRangedInt <= high)
                {
                    hasValue = true;
                }
                else
                {
                    System.out.println("Invalid input (must be in range): " + retRangedInt);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Invalid input (Needs an integer): " + trash);
            }


        }while(!hasValue);

        return retRangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retRangedDouble = 0;
        String trash = "";
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: " );
            if(pipe.hasNextDouble())
            {
                retRangedDouble = pipe.nextDouble();
                pipe.nextLine();

                if(retRangedDouble >= low && retRangedDouble <= high)
                {
                    hasValue = true;
                }
                else
                {
                    System.out.println("Invalid input (must be in range): " + retRangedDouble);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Invalid input (Cannot use letters): " + trash);
            }


        }while(!hasValue);

        return retRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {

        String yesOrNo = "";
        boolean YN = true;
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            yesOrNo = pipe.nextLine();
            if (yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("n"))
            {
                hasValue = true;
                if(yesOrNo.equals("y"))
                {
                    YN = true;
                }
                else
                {
                    YN =  false;
                }
            }
            else
            {
                System.out.println("Invalid input (must be Y/N): " + yesOrNo);
            }
        }while(!hasValue);

        return YN;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retValue = "";
        boolean hasValue = false;

        do
        {
            System.out.print(prompt + ": ");

            retValue = pipe.nextLine();


            if(retValue.matches(regEx))
            {
                hasValue = true;
            }
            else
            {
                System.out.println("Invalid input: " + retValue);
            }


        }while(!hasValue);

        return retValue;
    }

    public static void prettyHeader(Scanner pipe)
    {
        int messageLength = 0;
        int spacesNeeded = 0;
        int oddOrEven = 0;

        Scanner in = new Scanner(System.in);

        String message = "";

        message = SafeInput.getNonZeroLenString(in, "Enter your message");

        messageLength = message.length();

        for(int num = 1; num <= 60; num++)
        {
            System.out.print("*");
        }
        System.out.print("\n");

        for(int num = 1; num <= 3; num++)
        {
            System.out.print("*");
        }

        spacesNeeded = 27 - messageLength / 2;

        oddOrEven = messageLength % 2;


        for(int cnt = 1; cnt <= spacesNeeded; cnt++)
        {
            System.out.print(" ");
        }

        System.out.print(message);

        if(oddOrEven == 1)
        {
            spacesNeeded--;
        }

        for(int cnt = 1; cnt <= spacesNeeded; cnt++)
        {
            System.out.print(" ");
        }

        for(int num = 1; num <= 3; num++)
        {
            System.out.print("*");
        }
        System.out.print("\n");

        for(int num = 1; num <= 60; num++)
        {
            System.out.print("*");
        }
    }

}