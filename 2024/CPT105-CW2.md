# CPT105 - Coursework 2

This markdown file contains multiple-choice questions for CPT105 Coursework 2. A **non-official** solution is provided for each question for reference.

:bulb: If you find any concepts difficult to understand, it is strongly recommended to review the lecture notes for the class. They provide detailed explanations and examples that can help clarify any doubts you may have.

---

> According to the code fragment provided, which option’s return value is -1?
> 
> ```java
> public static int checkStr(String str1, String str2) {
>     int n = str1.length(), m = str2.length();
>     for (int i = 0; i + m <= n; i++) {
>         boolean flag = true;
>         for (int j = 0; j < m; j++) {
>             if (str1.charAt(i + j) != str2.charAt(j)) {
>                 flag = false;
>                 break;
>             }
>         }
>         if (flag) return i;
>     }
>     return -1;
> }
> ```
> 
> - **Option A:** `checkStr("abcdef", "abcd")`
> 
> - **Option B:** `checkStr("abcdef", "acd")`
> 
> - **Option C:** `checkStr("abcdef", "bcd")`
> 
> - **Option D:** `checkStr("abcdef", "cde")`

**Explanation** The function `checkStr` attempts to find the index at which `str2` appears as a substring in `str1`. If it finds `str2` in `str1`, it returns the starting index; otherwise, it returns `-1`.

- **Option A:** `"abcd"` is found starting at index `0` in `"abcdef"`, so it returns `0`.
- **Option B:** `"acd"` does not appear as a contiguous substring in `"abcdef"`, so it returns `-1`.
- **Option C:** `"bcd"` is found starting at index `1` in `"abcdef"`, so it returns `1`.
- **Option D:** `"cde"` is found starting at index `2` in `"abcdef"`, so it returns `2`.

**Answer:** The correct option is `B` (`checkStr("abcdef", "acd")`), which returns `-1`.

---
> The IDE (such as IntelliJ IDEA, NetBeans, Eclipse) will mark your code with an underline whenever the following type of error exists in your code.
> 
> - **Option A:** Programme error
> - **Option B:** Compile error
> - **Option C:** Runtime error
> - **Option D:** Logical error

**Explanation:** The IDE will mark your code with an underline whenever a compile error exists in your code. 
- **Option A:** *Programme error* is a general term that can refer to any type of error in a program, including *compile errors*, *runtime errors* and *logical errors*.
- **Option B:** *Compile error* occurs when the code does not compile due to syntax errors or other issues, and the IDE will mark these errors.
- **Option C:** *Runtime error* occurs when the programme is running and encounters an issue that causes it to crash or behave unexpectedly, but the IDE may not mark these errors, as they are not detected until runtime.
- **Option D:** *Logical error* occurs when the programme runs without crashing, but produces incorrect results due to a mistake in the logic of the code (e.g., incorrect calculations or indefinite loops), and the IDE may not mark these errors.

**Answer:** The correct option is `B` (Compile error).

---

> How do you call a method without parameters in Java?
> - **Option A:** `methodName();`
> - **Option B:** `methodName;`
> - **Option C:** `methodName[];`
> - **Option D:** `(methodName);`

**Explanation:** To call a method without parameters in Java, you use the syntax `methodName();`. 

**Answer:** The correct option is `A` (`methodName();`).

---

> Read the following code fragment.
> ```java
>  1 public class MyDate
>  2 {
>  3     public String month;
>  4     public int day;
>  5     public int year;
>  6  
>  7     public MyDate(String month, int day, int year) {
>  8         this.month = month;
>  9         this.day = day;
> 10         this.year = year;
> 11     }
> 12 
> 13     public void printDate()
> 14     {
> 15         System.out.println(month + " " + day + ", " + year);
> 16     }
> 17 }
> ```
> Q1. Select the line number(s) of the class `MyDate` that corresponds to the constructor.
> - **Option 1A:** Line 1
> - **Option 1B:** Line 6-10
> - **Option 1C:** Line 11-14
> - **Option 1D:** Line 3-5
> 
> Q2. Select the line number(s) of the class `MyDate` that corresponds to the instance variables.
> - **Option 2A:** Line 11-14
> - **Option 2B:** Line 3-5
> - **Option 2C:** Line 7-9
> - **Option 2D:** Line 6-10
> 
> Q3. Select the line number(s) of the class `MyDate` that corresponds to the instance method.
> - **Option 3A:** Line 1
> - **Option 3B:** Line 3-5
> - **Option 3C:** Line 11-14
> - **Option 3D:** Line 6-10
>
> Q4. Select the line number(s) of the class `MyDate` that should be declared as `private` to follow the encapsulation principle.
> - **Option 4A:** Line 3-5
> - **Option 4B:** Line 6
> - **Option 4C:** Line 1
> - **Option 4D:** Line 11

**Explanation:**
- **Q1:** The constructor in Java is a special method with the same name as the class and no return type, used to initialise the instance variables of the class. 
- **Q2:** Instance variables are declared at the class level and are used to store the state of an object, in this case, `month`, `day`, and `year`.
- **Q3:** Instance methods are methods that operate on the instance variables of an object, in this case, `printDate`.
- **Q4:** To follow the encapsulation principle, instance variables should be declared as `private` to restrict direct access from outside the class.

**Answers:**
- **Q1:** The correct option is `B` (Line 6-10).
- **Q2:** The correct option is `B` (Line 3-5).
- **Q3:** The correct option is `C` (Line 11-14).
- **Q4:** The correct option is `A` (Line 3-5).

---

> What is the correct way to create an object called `myObj` of `MyClass`?
> - **Option A**: `class myObj = new MyClass();`
> - **Option B**: `new myObj = MyClass();`
> - **Option C**: `MyClass myObj = new MyClass();`
> - **Option D**: `class MyClass = new MyObj();`

**Explanation:** To create an object of a class in Java, use the syntax `ClassName objectName = new ClassName();`.

**Answer:** The correct option is `C` (`MyClass myObj = new MyClass();`).

---

> *Calculation order in Java*
> 
> Q1. What is the result of the expression `(11 + 3 * 8) / 4 % 3`?
> - **Option 1A:** `2`
> - **Option 1B:** `31`
> - **Option 1C:** `0`
> - **Option 1D:** `1`
> 
> Q2. Which of the following expressions results in `5` when evaluated?
> - **Option 2A:** `20 / 2 + 2`
> - **Option 2B:** `7 + 3 / 2`
> - **Option 2C:** `3 + 5 / 2`
> - **Option 2D:** `2 / 3 + 4`

**Explanation:** By evaluation order that calculate the division / multiplication first, then addition / subtraction, and finally the modulo operation.
- **Q1:** `(11 + 3 * 8) / 4 % 3` = `(11 + 24) / 4 % 3` = `35 / 4 % 3` = `8 % 3` = `2`.
- **Q2:** 
  - **Option 2A:** `20 / 2 + 2` = `10 + 2` = `12`.
  - **Option 2B:** `7 + 3 / 2` = `7 + 1` = `8`.
  - **Option 2C:** `3 + 5 / 2` = `3 + 2` = `5`.
  - **Option 2D:** `2 / 3 + 4` = `0 + 4` = `4`.

**Answer:**
- **Q1:** The correct option is `A` (`2`).
- **Q2:** The correct option is `C` (`3 + 5 / 2`).

---

> Which of the following is NOT a Boolean operator in Java?
> - **Option A:** `||`
> - **Option B:** `&&`
> - **Option C:** `!`
> - **Option D:** `//`

**Explanation:** In Java, `//` is the single-line comment operator, not a Boolean operator.
- **Option A:** `||` is the logical OR operator, used to check if at least one of the two conditions is true.
- **Option B:** `&&` is the logical AND operator, used to check if both conditions are true.
- **Option C:** `!` is the logical NOT operator, used to negate a Boolean value (e.g., `!true` is `false`).
- **Option D:** `//` is used to start a single-line comment in Java.

**Answer:** The correct option is `D` (`//`).

---

> Which of the following operator can be used to compare two values in Java?
> - **Option A:** `><`
> - **Option B:** `==`
> - **Option C:** `=`
> - **Option D:** `<>`

**Explanation:** The `==` operator is used to compare two values for equality in Java. The `=` operator is used for assignment, not comparison. The remaining operators are not valid comparison operators in Java.

**Answer:** The correct option is `B` (`==`).

---

> What is performed when `+` operator is used with two strings in Java?
> - **Option A:** Addition
> - **Option B:** Concatenation
> - **Option C:** Subtraction
> - **Option D:** Deletion

**Explanation:** When the `+` operator is used with two strings in Java, it performs string concatenation, joining the two strings together.

**Answer:** The correct option is `B` (Concatenation).

---

> Which of the following MUST end with a semicolon in Java?
> - **Option A:** A block of code
> - **Option B:** A statement
> - **Option C:** An expression
> - **Option D:** A method declaration

**Explanation:** In Java, a statement must end with a semicolon to indicate the end of the statement.

**Answer:** The correct option is `B` (A statement).

---

> *Keywords in Java*
> 
> Q1. Which one of the following is a keyword in Java?
> - **Option 1A:** `positive`
> - **Option 1B:** `transfer`
> - **Option 1C:** `escape`
> - **Option 1D:** `class`
>
> Q2. What is the keyword used to create a new instance of a class in Java?
> - **Option 2A:** `new`
> - **Option 2B:** `this`
> - **Option 2C:** `object`
> - **Option 2D:** `instance`
>
> Q3. What is the keyword used to refer to the current instance of an object within a class in Java?
> - **Option 3A:** `new`
> - **Option 3B:** `this`
> - **Option 3C:** `class`
> - **Option 3D:** `instance`

**Explanation:** Java keywords are reserved words with special meanings that cannot be used as identifiers (e.g., variable names, method names). Here are some examples:

- `class`: Declares a class. Example: `public class MyClass { ... }`.
- `new`: Creates a new instance of a class. Example: `MyClass obj = new MyClass();`.
- `this`: Refers to the current instance of an object within a class. Example: `this.variableName`.
- `public`, `private`, `protected`: Specify the visibility of classes, methods, and variables.
- `for`, `while`: Control loops.
- `if`, `else`: Control conditional statements.
- `void`: Indicates that a method does not return a value.
- `return`: Returns a value from a method.

These keywords have specific functions and cannot be used as identifiers in Java programmes. Based on the given options in the questions:
- **Q1:** `class` is a keyword used to declare a class.
- **Q2:** `new` is a keyword used to create a new instance of a class.
- **Q3:** `this` is a keyword used to refer to the current instance of an object within a class.

**Answer:** 
- **Q1:** The correct option is `D` (`class`).
- **Q2:** The correct option is `A` (`new`).
- **Q3:** The correct option is `B` (`this`).

---

> What is the output of the following code?
> ```java
> public class Test {
>     public static void main(String[] args) {
>         String x = "abc";
>         String y = "cba";
>         y.concat(x);
>         System.out.println(y);
>     }
> }
> ```
> - **Option A:** `abc`
> - **Option B:** `cba`
> - **Option C:** `cbacba`
> - **Option D:** `abccba`

**Explanation:** Strings in Java are immutable, so the `concat` method does not modify the original string but returns a new string. In this case, `y.concat(x)` does not change the value of `y`, so the output is `cba`.

**Answer:** The correct option is `B` (`cba`).

---

> Which is not the overloading of the display method?
> ```java
> private static void display(int a) {
>     System.out.println("Argument: " + a);
> }
> ```
> - **Option A:** `private static int display(int a) { ... }`
> - **Option B:** `private static void display(String a) { ... }`
> - **Option C:** `private static void display(int a, int b, int c) { ... }`
> - **Option D:** `private static void display(int a, int b) { ... }`

**Explanation:** Overloading occurs when multiple methods in the same class have the same name but different parameters. The method `private static int display(int a) { ... }` is not an overload of the `display` method because it has a different return type.

**Answer:** The correct option is `A` (`private static int display(int a) { ... }`).

---

> What is the output of the following code?
> ```java
> public static int negate(int x) {
>     x = -x;
>     return x;
> }
> public static void main(String[] args) {
>     int x = 5;
>     System.out.print(x);
>     x = negate(x);
>     System.out.print(x);
> }
> ```
> - **Option A:** `55`
> - **Option B:** `5-5`
> - **Option C:** `-55`
> - **Option D:** `-5-5`

**Explanation:** The `negate` method takes an integer `x` and returns the negation of `x`. In the `main` method, `x` is initially `5`, so `5` is printed, then `x` is negated to `-5`, which is printed next.

**Answer:** The correct option is `D` (`5-5`).

---

> Which of the following code is not true in Java?
> - **Option A:** `double [] values = {2,3,4,5}`
> - **Option B:** `int [] values = {2,3,4,5}`
> - **Option C:** `int [] values = {2,3.5,4,5}`
> - **Option D:** `double [] values = {2,3,4,5}`

**Explanation:** In Java, when initialising an array, the values must be of the same type as the array type.
- **Option A:** `double [] values = {2,3,4,5}` is valid.
- **Option B:** `int [] values = {2,3,4,5}` is valid.
- **Option C:** `int [] values = {2,3.5,4,5}` is not valid because `3.5` is a `double` value, not an `int`.
- **Option D:** `double [] values = {2,3,4,5}` is valid.

**Answer:** The correct option is `C` (`int [] values = {2,3.5,4,5}`).

---

> How to determine if two strings are consist of the same characters in Java?
> - **Option A:** `compareTo()` method
> - **Option B:** `compare()` method
> - **Option C:** `equals()` method
> - **Option D:** `==` method

**Explanation:** In Java, you can use the `equals()` method to determine if two strings have the same characters.
- **Option A:** `compareTo()` method is used to compare two strings lexicographically (i.e., based on the Unicode values of the characters) and returns an integer value indicating the comparison result (e.g., negative, zero, or positive). For instance, `"abc".compareTo("def")` would return a negative value; `"abc".compareTo("abc")` would return `0`; and `"def".compareTo("abc")` would return a positive value.
- **Option B:** There is no `compare()` method for comparing strings.
- **Option C:** The `equals()` method is used to compare the content of two strings.
- **Option D:** The `==` operator compares references for objects, not the actual content of the strings.

**Answer:** The correct option is `C` (`equals()` method).

---

> How many times will the following loop execute?
> ```java
> for (int i = 0; i < 5; i++) {...}
> ```
> - **Option A:** 5
> - **Option B:** 6
> - **Option C:** 4
> - **Option D:** 0

**Explanation:** The loop will execute as long as `i` is less than `5`, so it will execute `5` times (when `i` is `0`, `1`, `2`, `3`, and `4`).

**Answer:** The correct option is `A` (5).

---

> In a `for` loop, where is the condition checked?
> - **Option A:** Only at the beginning of the loop
> - **Option B:** Only at the end of the loop
> - **Option C:** Before the `for` loop body
> - **Option D:** After the `for` loop body

**Explanation:** In a `for` loop, the condition is checked at the beginning of each iteration, before executing the loop body.

**Answer:** The correct option is `A` (Only at the beginning of the loop).

---

> How to convert Fahrenheit (`f`) to Celsius (`c`) in Java?
> - **Option A:** `double c = (f - 32) * 5 / 9;`
> - **Option B:** `double c = (f - 32) * 9 / 5;`
> - **Option C:** `double c = (f * 5 / 9) - 32;`
> - **Option D:** `double c = (f - 32 * 5) / 9;`

**Explanation:** To convert Fahrenheit ($F$) to Celsius ($C$), you can use the formula $C = \frac{5}{9}\left(F - 32\right)$.
Considering the calculation order in Java, the correct option is `A` (`double c = (f - 32) * 5 / 9;`).

**Answer:** The correct option is `A` (`double c = (f - 32) * 5 / 9;`).

---

> Select the pairs of `x` and `y` that satisfy the following condition:
> ```java
> boolean b = (x % 7 == 0) && (y % 8 == 0);
> ```
> - **Option A:** `x = 14`, `y = 21`
> - **Option B:** `x = 32`, `y = 48`
> - **Option C:** `x = 16`, `y = 56`
> - **Option D:** `x = 35`, `y = 24`

**Explanation:** The condition `(x % 7 == 0) && (y % 8 == 0)` checks if `x` is divisible by `7` and `y` is divisible by `8` (i.e., both `x` and `y` are multiples of `7` and `8`, respectively).

- **Option A:** `x = 14`, `y = 21`:
  - `14 % 7 == 0` is `true`.
  - `21 % 8 == 0` is `false`.
  - The condition is `false`.
- **Option B:** `x = 32`, `y = 48`:
  - `32 % 7 == 0` is `false`.
  - `48 % 8 == 0` is `true`.
  - The condition is `false`.
- **Option C:** `x = 16`, `y = 56`:
  - `16 % 7 == 0` is `false`.
  - `56 % 8 == 0` is `true`.
  - The condition is `false`.
- **Option D:** `x = 35`, `y = 24`:
  - `35 % 7 == 0` is `true`.
  - `24 % 8 == 0` is `true`.
  - The condition is `true`.

**Answer:** The correct option is `D` (`x = 35`, `y = 24`).

---

> Given two `int` variables `a` and `b`, what is the result of the following code?
> ```java
> int c = a;
> b = c;
> a = b;
> ``` 
> - **Option A:** The values of `a` and `b` are exchanged.
> - **Option B:** The values of `a`, `b` and `c` become `0`.
> - **Option C:** The values of `a` and `b` remain unchanged.
> - **Option D:** The values of `a`, `b` and `c` become the value of `a`.

**Explanation:** The code snippet assigns the value of `a` to `c`, then assigns the value of `c` to `b`, and finally assigns the value of `b` to `a`. This results in `a` and `b` swapping values.

**Answer:** The correct option is `A` (The values of `a` and `b` are exchanged).

---

> What is the main component of a Java `class`?
> - **Option A:** Methods and Attributes
> - **Option B:** Variables and Functions
> - **Option C:** Constructor and Destructor
> - **Option D:** Objects and References

**Explanation:** The main components of a Java `class` are methods and attributes (variables).
- **Option A:** Methods and Attributes are the primary components of a Java class.
- **Option B:** Variables and Functions are part of a class but not the main components.
- **Option C:** Constructor and Destructor are special methods in a class but not the main components.
- **Option D:** Objects and References are related to instances of a class but not the main components of the class itself.

**Answer:** The correct option is `A` (Methods and Attributes).

---

> What is the output of the following code?
> ```java
> System.out.println("Hello,World".split(",")[1]);
> ```
> - **Option A:** `Hello`
> - **Option B:** `World`
> - **Option C:** `Hello,World`
> - **Option D:** `HelloWorld`

**Explanation:** The `split` method splits a string into an array of substrings based on the provided delimiter. In this case, the string `"Hello,World"` is split at the comma `,`, resulting in an array `["Hello", "World"]`. The `[1]` index accesses the second element of the array, which is `"World"`.

**Answer:** The correct option is `B` (`World`).

---

> What is the output of the following code?
> ```java
> int count = 0;
> for (int i = 0; i <= 10; i = i + 2) {
>     count += i;
> }
> System.out.println(count);
> ```
> - **Option A:** `1`
> - **Option B:** `20`
> - **Option C:** `55`
> - **Option D:** `30`

**Explanation:** The loop starts at `i = 0` and increments `i` by `2` in each iteration. The loop runs for `6` iterations (`0`, `2`, `4`, `6`, `8`, `10`), and the sum of these numbers is `30`.

**Answer:** The correct option is `D` (`30`).

---

> What is the output of the following code?
> ```java
> int x = 5;
> if (x >= 1) {
>     System.out.print("Statement 1 ");
> } else if (x >= 2) {
>     System.out.print("Statement 2 ");
> } else if (x >= 3) {
>     System.out.print("Statement 3 ");
> } else {...}
> ```
> - **Option A:** `Statement 1 `
> - **Option B:** `Statement 2 Statement 2 `
> - **Option C:** `Statement 3 `
> - **Option D:** `Statement 1 Statement 2 Statement 3 `

**Explanation:** The `if` condition `x >= 1` is true for `x = 5`, so `"Statement 1 "` is printed. The subsequent `else if` conditions are not checked because the first condition is true.

**Answer:** The correct option is `A` (`Statement 1 `).

---

> What is the return value declared on a method that does not return any value to the method caller in Java?
> - **Option A:** `void`
> - **Option B:** `null`
> - **Option C:** `int`
> - **Option D:** `this`

**Explanation:** In Java, a method that does not return any value to the method caller is declared with a return type of `void`.

**Answer:** The correct option is `A` (`void`).

---

> What is the value of `b` after the execution of the following code?
> ```java
> int a = 12456789;
> int b = 0;
> while (a != 0) {
>     b = (10 * b) + (a % 10);
>     a = a / 10;
> }
> ```
> - **Option A:** `98765421`
> - **Option B:** `12345789`
> - **Option C:** `0`
> - **Option D:** `1`

**Explanation:** The code snippet reverses the digits of the number `a` by extracting the last digit of `a` and appending it to the end of `b`. After the loop completes, `b` will contain the reversed digits of `a`.

**Answer:** The correct option is `A` (`98765421`).

---

> What is the output of the following code?
> ```java
> public class Test{
>     public static void main(String[] args) {
>         int x = 5 * 20 - 10;
>         System.out.println(x);
>     }
> }
> ```
> - **Option A:** Runtime error
> - **Option B:** `90`
> - **Option C:** `0`
> - **Option D:** Compile-time error

**Explanation:** The code calculates `5 * 20 - 10` which is equal to `100 - 10 = 90`, so the output will be `90`.

**Answer:** The correct option is `B` (`90`).

---

> Which is the correct positions to print a new line (`System.out.println()`) in the following code in order to print a $10\times10$ matrix?
> ```java
> for (int row = 1; row <= 10; row++) {
> // position 1
>     for (int col = 1; col <= 10; col++) {
>         System.out.print(row * col + "\t");
> // position 2
>     }
> // position 3
> }
> // position 4
> ```
> - **Option A:** Position 1
> - **Option B:** Position 2
> - **Option C:** Position 3
> - **Option D:** Position 4

**Explanation:** To print a $10\times10$ matrix, a new line should be printed after each row is completed. This means that the `System.out.println()` statement should be placed at the end of the inner loop, after printing all the columns for a given row.

**Answer:** The correct option is `C` (Position 3).

---

> Which method can be used to find the length of a string in Java?
> - **Option A:** `getLength()`
> - **Option D:** `length()`
> - **Option C:** `getSize()`
> - **Option B:** `size()`

**Explanation:** In Java, the `length()` method is used to find the length of a string.

**Answer:** The correct option is `B` (`length()`).

---

> Which of the following code prints "Hello, World" in Java?
> - **Option A:** `echo("Hello, World");`
> - **Option B:** `print("Hello, World");`
> - **Option C:** `System.out.println("Hello, World");`
> - **Option D:** `Console.WriteLine("Hello, World");`

**Explanation:** In Java, the standard way to print output to the console is using `System.out.println("Hello, World");`.

**Answer:** The correct option is `C` (`System.out.println("Hello, World");`).

---

> Which of the following `for` loop declarations is NOT valid in Java?
> - **Option A:** `for (int i = 100; i >= 1; i / 5)`
> - **Option B:** `for (int i = 0; i <= 100; i = 5*i)`
> - **Option C:** `for (int i = 0; i <= 100; i += 5)`
> - **Option D:** `for (int i = 100; i >= 2; --i)`

**Explanation:**
- **Option A:** The loop declaration `for (int i = 100; i >= 1; i / 5)` is not valid because the update expression `i / 5` does not modify the loop variable `i`.
- **Option B:** The loop declaration `for (int i = 0; i <= 100; i = 5*i)` is correct.
- **Option C:** The loop declaration `for (int i = 0; i <= 100; i += 5)` is correct.
- **Option D:** The loop declaration `for (int i = 100; i >= 2; --i)` is correct.

**Answer:** The correct option is `A` (`for (int i = 100; i >= 1; i / 5)`).

---

> Which of the following is the correct way to comment a single line in Java?
> - **Option A:** `// This is a comment`
> - **Option B:** `/* This is a comment`
> - **Option C:** `<!-- This is a comment -->`
> - **Option D:** `# This is a comment`

**Explanation:** In Java, a single-line comment is denoted by `//`.
- **Option A:** `// This is a comment` is a valid single-line comment.
- **Option B:** `/* This is a comment` is the start of a multi-line comment. The comment should be closed with `*/`. For example, `/* This is a comment */`.
- **Option C:** `<!-- This is a comment -->` is an HTML/XML comment syntax, not Java.
- **Option D:** `# This is a comment` is used in other languages like Python and shell scripting, but not in Java.

**Answer:** The correct option is `A` (`// This is a comment`).

---

> Which of the following method results in a new string that the first string `str1` is followed by the second string `str2`?
> - **Option A:** `str1.concat(str2)`
> - **Option B:** `str1.join(str2)`
> - **Option C:** `str1.append(str2)`
> - **Option D:** `str1.combine(str2)`

**Explanation:** In Java, the `concat` method is used to concatenate two strings, resulting in a new string that is the combination of the two input strings.

**Answer:** The correct option is `A` (`str1.concat(str2)`).

