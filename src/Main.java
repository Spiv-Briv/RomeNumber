public class Main {
    public static void main(String[] args) {
        RomeNumber number1 = new RomeNumber("CXXV");
        RomeNumber number2 = new RomeNumber("XXV");
        System.out.println(number1);
        System.out.println(number2);
        number1.add(number2);
        System.out.println(number1 + " == " + number1.getComputable());
        number1.setValue("CXXV");
        number1.substract(number2);
        System.out.println(number1 + " == " + number1.getComputable());
        number1.setValue("CXXV");
        number1.multiply(number2);
        System.out.println(number1 + " == " + number1.getComputable());
        number1.setValue("CXXV");
        number1.divide(number2);
        System.out.println(number1 + " == " + number1.getComputable());
        number1.setValue("CXXV");
    }


}