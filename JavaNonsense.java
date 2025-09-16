import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

class JavaNonsense {
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Which program do you wish to access?\n1. MORTGAGE CALCULATOR\n2. ROLES\n3. FIZZBUZZ\n4. CALCULATOR\n5. RANDOM NUMBER\n6. SAVE ENCODER\n\nProgram: ");
       String in = scanner.nextLine();
       switch(in){
           case "1":
               mortgage();
               break;
           case "2":
               user();
               break;
           case "3":
               fizzbuzz();
               break;
           case "4":
               calculator();
               break;
           case "5":
               generand();
               break;
           case "6":
               saves();
               break;
           default:
               System.out.println("ERROR: The program requested does not exist");
       }
   }


   public static void mortgage(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("What do you wish to calculate?\n1. ELIGIBILITY\n2. MORTGAGE\n\nMode: ");
       int type = Integer.parseInt(scanner.nextLine());
       if(type == 1){
           System.out.print("Calculating: ELIGIBILITY\n");
           System.out.print("Income: ");
           int inc = Integer.parseInt(scanner.nextLine());
           System.out.print("Credit (As percent): ");
           int cred = Integer.parseInt(scanner.nextLine());
           System.out.print("Criminal Record (y/n): ");
           String in = scanner.nextLine();
           boolean crim = in.equals("y");
           System.out.println(Mortgage.eligible(inc, cred, crim));
       }


       if(type == 2) {
           float x = 0f;
           boolean met = false;
           while(!met){
               System.out.print("Principal [£1K - £1M] : ");
               x = Float.parseFloat(scanner.nextLine());
               if(x > 1000f && x < 1000000f)
                   met = true;
               else
                   System.out.println("Enter a number between 1000 and 1000000.");
           }
           float y = 0f;
           met = false;
           while(!met) {
               System.out.print("Interest (Annual) [>0 and <=30] : ");
               y = Float.parseFloat(scanner.nextLine());
               if(y > 0f && y <= 30f)
                   met = true;
               else
                   System.out.println("Enter a number between 1 and 30");
           }
           met = false;
           int z = 0;
           while(!met) {
               System.out.print("Length (Years) [>0 and <=30] : ");
               z = Integer.parseInt(scanner.nextLine());
               if(z > 0 && z <= 30)
                   met = true;
               else
                   System.out.println("Enter a number between 1 and 30");
           }
               System.out.println(Mortgage.calculate(x, y, z));
       }
   }


   public static void saves(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Save/Load: ");
       String choice = scanner.nextLine().toLowerCase();
       if(choice.equals("save")){
           System.out.print("Health [0 - 999]: ");
           String health = scanner.nextLine();
           System.out.print("Max Health [0 - 999]: ");
           String maxhp = scanner.nextLine();
           System.out.print("Story Progress [0 - 99]: ");
           String storyp = scanner.nextLine();
           System.out.print("Items Carried [0 - 9999]: ");
           String items = scanner.nextLine();


           while(health.length() < 3){
               health = 0 + health;
           }
           while(maxhp.length() < 3){
               maxhp = 0 + maxhp;
           }
           while(storyp.length() < 2){
               storyp = 0 + storyp;
           }
           while(items.length() < 4){
               items = 0 + items;
           }


           System.out.print("Save File: ");
           System.out.println(health + maxhp + storyp + items);
       }
       else if(choice.equals("load")){
           System.out.print("Save Data: ");
           String in = scanner.nextLine();
           String hp = in.substring(0, 3);
           String max = in.substring(3, 6);
           String story = in.substring(6, 8);
           String inv = in.substring(8, 12);
           while(hp.substring(0, 1).equals("0")){
               hp = hp.substring(1);
           }
           if(hp.equals("")){
               hp = "0";
           }
           while(max.substring(0, 1).equals("0")){
               max = max.substring(1);
           }
           if(max.equals("")){
               hp = "0";
           }
           while(story.substring(0, 1).equals("0")){
               story = story.substring(1);
           }
           if(story.equals("")){
               story = "0";
           }
           while(inv.substring(0, 1).equals("0")){
               inv = inv.substring(1);
           }
           if(inv.equals("")){
               inv = "0";
           }
           System.out.print("Health: ");
           System.out.println(hp);
           System.out.print("Max Health: ");
           System.out.println(max);
           System.out.print("Story Progress: ");
           System.out.println(story);
           System.out.print("Items Carried: ");
           System.out.println(inv);


       }
   }


   public static void user(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Role: ");
       String role = scanner.nextLine();
       switch(role){
           case "admin":
               System.out.println("role:: ADMIN");
               break;
           case "moderator":
               System.out.println("role:: MODERATOR");
               break;
           default:
               System.out.println("role:: GUEST");
       }


   }


   public static void calculator(){
       System.out.print("Calculation: ");
               Scanner scanner = new Scanner(System.in);
               String input = scanner.nextLine();
               String rx = "\\s";
               String[] splits = input.split(rx);
               float num1 = Float.parseFloat(splits[0]);
               String op = splits[1];
               float num2 = Float.parseFloat(splits[2]);
               float answer = 0f;
               String calculation = splits[0] + " " + splits[1] + " " + splits[2];
               if(op.equals("+")){
                   answer = num1 + num2;
               }
               if(op.equals("-")){
                   answer = num1 - num2;
               }
               if(op.equals("*")){
                   answer = num1 * num2;
               }
               if(op.equals("/")){
                   answer = num1 / num2;
               }
               System.out.println(calculation + " = " + answer);
           }


   public static void fizzbuzz(){
    FizzBuzz.collect();
    if(!FizzBuzz.determine())
        FizzBuzz.entry();
    else
        FizzBuzz.list();
   }


   public static void generand(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Type (trueint, int100, floater, truefloat, float100): ");
       String type = scanner.nextLine();
       type = switch (type) {
           case "trueint" -> "intrue";
           case "truefloat" -> "floatrue";
           default -> type;
       };
       Numbers.pseudoRand(type);
   }
}




class Numbers {
   public static void pseudoRand(String type) {
       int irandom = 0;
       float frandom = 0f;
       boolean float_ = false;
       boolean int_ = false;


       if (Objects.equals(type, "intrue")) {
           irandom = (int) Math.round(Math.random());
           int_ = true;
       }
       if (Objects.equals(type, "int100")) {
           irandom = (int) Math.round(Math.random() * 100);
           int_ = true;
       }
       if (Objects.equals(type, "floater")) {
           frandom = Math.round(Math.random() * 100);
           float_ = true;
       }
       if (Objects.equals(type, "floatrue")) {
           frandom = (float) Math.random();
           float_ = true;
       }
       if (Objects.equals(type, "float100")) {
           frandom = (float) Math.random() * 100;
           float_ = true;
       }
       if (int_) {
           System.out.println(irandom);
       }
       if (float_) {
           System.out.println(frandom);
       }
   }
   public static String reform(double input, String rtype, String aprin) {
       String result = "";
       if(Objects.equals(rtype, "currency.uk")){
           NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
           result = currency.format(input);
           if(Objects.equals(aprin, "t") || Objects.equals(aprin, "y")){
               System.out.println(result);
           }
       }
       if(Objects.equals(rtype, "percent") || Objects.equals(rtype, "%")){
           NumberFormat percentage = NumberFormat.getPercentInstance();
           result = percentage.format(input);
           if(Objects.equals(aprin, "t") || Objects.equals(aprin, "y")){
               System.out.println(result);
           }
       }
       return result;
   }
}
class Mortgage{
   public static String calculate(float principal, float inter, int years){
       float intermonth = inter / 12 / 100;
       float months = years * 12;
       double top = intermonth * Math.pow((1 + intermonth), months);
       double bottom = Math.pow((1 + intermonth), months) - 1;
       double total = principal * (top / bottom);
       String realt = Numbers.reform(total, "currency.uk", "");
       return "Mortgage: " + realt;
   }


   public static String eligible(int income, int cred, boolean crimRec){
       boolean highInc = income > 12000;
       boolean highCred = cred > 70;
       boolean eligt = (!crimRec) && (highInc || highCred);
       return "Eligible: " + eligt;
   }
}


class FizzBuzz{
   public static void collect(){
       System.out.print("Please pick a mode:\n1. LIST\n2. ENTER\n\nMode: ");
       }
   public static boolean determine(){
       Scanner scanner = new Scanner(System.in);
       String in = scanner.nextLine();
       return in.equals("1");
       }
   public static void list(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Please pick the number of items you wish for the list to contain\n\nItems: ");
       int t = scanner.nextInt() + 1;
       int x = 1;
       while(x < t){
           String tout = "";
           if(x % 3 == 0)
               tout += "Fizz";
           if(x % 5 == 0)
               tout += "Buzz";
           if(tout.isEmpty())
               tout = Integer.toString(x);
           x++;
           System.out.println(tout);
       }
       System.out.println();
           }


   public static void entry(){
       String tout = "";
       Scanner scanner = new Scanner(System.in);
       System.out.print("Please pick a number\n\nNumber: ");
       int x = scanner.nextInt();
       if(x % 3 == 0)
           tout += "Fizz";
       if(x % 5 == 0)
           tout += "Buzz";
       if(tout.isEmpty())
           tout = Integer.toString(x);
       System.out.println(tout);
       }


   }
