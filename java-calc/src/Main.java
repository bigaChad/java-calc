import java.util.Scanner;

public class Main {
    public static String calc(String str) throws Exception {
        int num1 = 0, num2 = 0, result = 0, temp = 0;
        boolean[] isRomanian = {false, false};
        String[] str2 = new String[3], romanianNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String tempUnits;
        char ch;

        for (int i = 0; i < str2.length; i++) {
            str2[i] = "";
        }

        try {
            for(int i = 0, j = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (ch != ' ') {
                    str2[j] += ch;
                } else j++;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            throw new Exception();
        }

        ch = str2[0].charAt(0);


        if (ch >= '1' && ch <= '9') {
            try {
                num1 = Integer.parseInt(str2[0]);
                num2 = Integer.parseInt(str2[2]);
            } catch (NumberFormatException exc) {
                throw new Exception();
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (str2[0].equals(romanianNumbers[i])) { num1 = i+1; isRomanian[0] = true; }
                if (str2[2].equals(romanianNumbers[i])) { num2 = i+1; isRomanian[1] = true; }
            } if (isRomanian[0] != true || isRomanian[1] != true) throw new Exception();
        }

        if (num1 > 10 || num2 > 10) throw new Exception();

        if (str2[1].equals("+")) {
            result = num1 + num2;
        } else if (str2[1].equals("-")) {
            result = num1 - num2;
        } else if (str2[1].equals("*")) {
            result = num1 * num2;
        } else if (str2[1].equals("/")) {
            result = num1 / num2;
        } else throw new Exception();

        if (isRomanian[0] == true && isRomanian[1] == true) {
            if (result == 0) throw new Exception();
            else if ((result / 100) == 1) return "L";
            else if ((result / 50) == 1) {
                temp = (result / 10) - 5;
                if  (result % 10 != 0) {
                    return "C" + "X".repeat(temp) + romanianNumbers[result % 10-1];
                } else return "C" + "X".repeat(temp);
            } else {
                temp = (result / 10);
                if  (result % 10 != 0) {
                    return "X".repeat(temp) + romanianNumbers[result % 10-1];
                }   return "X".repeat(temp);
            }
        }
        return Integer.toString(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        System.out.print("Your task: ");
         try {
            str = calc(in.nextLine());
        } catch (Exception exc) {
            System.out.println("Invalid input");
            System.exit(1);;
        }
        System.out.println(str);
    }
}


/*

import java.util.Scanner;

public class Main {
    public static String calc(String str) throws Exception {
        int num1 = 0, num2 = 0, result = 0, temp = 0;
        boolean[] isRomanian = {false, false};
        String[] str2 = new String[3], romanianNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String tempUnits;
        char ch;

        for (int i = 0; i < str2.length; i++) {
            str2[i] = "";
        }

        try {
            for(int i = 0, j = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (ch != ' ') {
                    str2[j] += ch;
                } else j++;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            throw new Exception();
        }

        ch = str2[0].charAt(0);


        if (ch >= '1' && ch <= '9') {
            try {
                num1 = Integer.parseInt(str2[0]);
                num2 = Integer.parseInt(str2[2]);
            } catch (NumberFormatException exc) {
                throw new Exception();
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (str2[0].equals(romanianNumbers[i])) { num1 = i+1; isRomanian[0] = true; }
                if (str2[2].equals(romanianNumbers[i])) { num2 = i+1; isRomanian[1] = true; }
            } if (isRomanian[0] != true || isRomanian[1] != true) throw new Exception();
        }

        if (num1 > 10 || num2 > 10) throw new Exception();

        if (str2[1].equals("+")) {
            result = num1 + num2;
        } else if (str2[1].equals("-")) {
            result = num1 - num2;
        } else if (str2[1].equals("*")) {
            result = num1 * num2;
        } else if (str2[1].equals("/")) {
            result = num1 / num2;
        } else throw new Exception();

        if (isRomanian[0] == true && isRomanian[1] == true) {
            if (result == 0) throw new Exception();
            else if ((result / 100) == 1) return "L";
            else if ((result / 50) == 1) {
                temp = (result / 10) - 5;
                if  (result % 10 != 0) {
                    return "C" + "X".repeat(temp) + romanianNumbers[result % 10-1];
                } else return "C" + "X".repeat(temp);
            } else {
                temp = (result / 10);
                if  (result % 10 != 0) {
                    return "X".repeat(temp) + romanianNumbers[result % 10-1];
                }   return "X".repeat(temp);
            }
        }
        return Integer.toString(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        System.out.print("Your task: ");
         try {
            str = calc(in.nextLine());
        } catch (Exception exc) {
            System.out.println("Invalid input");
            System.exit(1);;
        }
        System.out.println(str);
    }
}


 */