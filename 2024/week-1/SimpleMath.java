public class SimpleMath {
    public static void main(String[] args) {
        int intNum1 = 13;
        int intNum2 = 5;
        float floatNum1 = 13.0f;
        float floatNum2 = 5.0f;

        // division
        System.out.println("division operation");
        System.out.println(intNum1 + " / " + intNum2 + " = " + (intNum1 / intNum2));
        System.out.println(floatNum1 + " / " + floatNum2 + " = " + (floatNum1 / floatNum2));
        System.out.println(intNum1 + " / " + floatNum2 + " = " + (intNum1 / floatNum2));
        System.out.println(floatNum1 + " / " + intNum2 + " = " + (floatNum1 / intNum2));

        // modulo
        System.out.println("modulo operation");
        System.out.println(intNum1 + " % " + intNum2 + " = " + (intNum1 % intNum2));
        System.out.println(floatNum1 + " % " + floatNum2 + " = " + (floatNum1 % floatNum2));
        System.out.println(intNum1 + " % " + floatNum2 + " = " + (intNum1 % floatNum2));
        System.out.println(floatNum1 + " % " + intNum2 + " = " + (floatNum1 % intNum2));
    }
}
