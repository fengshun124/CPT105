public class SimpleMath {
    public static void main(String[] args) {
        int intNum1 = 13;
        int intNum2 = 5;
        
        double doubleNum1 = 13.0d;
        double doubleNum2 = 5.0d;
        
        float floatNum1 = 13.0f;
        float floatNum2 = 5.0f;

        // Division
        System.out.println("Division operation");
        // int / int
        System.out.println("int / int: " + intNum1 + " / " + intNum2 + " = " + (intNum1 / intNum2));  
        // float / float
        System.out.println("float / float: " + floatNum1 + " / " + floatNum2 + " = " + (floatNum1 / floatNum2));  
        // int / float
        System.out.println("int / float (explicit cast): " + intNum1 + " / " + floatNum2 + " = " + ((float)intNum1 / floatNum2));  
        // float / int
        System.out.println("float / int: " + floatNum1 + " / " + intNum2 + " = " + (floatNum1 / intNum2));  
        // double / double
        System.out.println("double / double: " + doubleNum1 + " / " + doubleNum2 + " = " + (doubleNum1 / doubleNum2));  
        
        // More Division with Explicit Casting
        System.out.println("Division with Explicit Casting");
        // int / double
        System.out.println("int / double (explicit cast): " + intNum1 + " / " + doubleNum2 + " = " + ((double)intNum1 / doubleNum2));
        // double / int
        System.out.println("double / int (implicit cast): " + doubleNum1 + " / " + intNum2 + " = " + (doubleNum1 / intNum2));  
        
        // Modulo
        System.out.println("Modulo operation");
        // int % int
        System.out.println("int % int: " + intNum1 + " % " + intNum2 + " = " + (intNum1 % intNum2));  
        // float % float
        System.out.println("float % float: " + floatNum1 + " % " + floatNum2 + " = " + (floatNum1 % floatNum2));  
        // int % float
        System.out.println("int % float: " + intNum1 + " % " + floatNum2 + " = " + (intNum1 % floatNum2));  
        // float % int
        System.out.println("float % int: " + floatNum1 + " % " + intNum2 + " = " + (floatNum1 % intNum2));  
        // double % double
        System.out.println("double % double: " + doubleNum1 + " % " + doubleNum2 + " = " + (doubleNum1 % doubleNum2));  
    }
}
