#simple Calculator
A Java Swing desktop calculator application that performs basic arithmetic operations (+, -, *, /). It
supports both button-based and keyboard input.
Features
- Addition, subtraction, multiplication, division
- Decimal point handling
- Backspace and clear (CLEAR) functionality
- Error handling for divide-by-zero and invalid operations
- Keyboard support (numbers, operators, Enter, Backspace)
- Styled buttons (operators in orange, others in light gray)
- Responsive display with right-aligned text
Technologies
- Java (JDK 8 or later)
- Swing (Java GUI framework)
- AWT event handling
How to Run
1. Compile the code:
 javac ImprovedCalculator.java
2. Run the application:
 java ImprovedCalculator
Controls
Buttons:
- 0-9: input digits
- +, -, *, /: arithmetic operators
- . : decimal point
- = : compute result
- CLEAR: reset calculator
- Backspace: delete last character
Keyboard:
- Number keys 0-9
- +, -, *, /
- . for decimal
- Enter to calculate
- Backspace to delete last character
Notes
- The calculator formats integer results without decimals using DecimalFormat.
- Displays 'Error /0' when attempting division by zero.
- Displays 'Invalid' if an unknown operation is attempted.
Author
- Developed as a learning project for Java Swing GUI and event handling.
