import java.util.Set;
import java.util.Stack;

public class RPNCalculator {
    // Zestaw operatorów dla łatwego sprawdzenia
    private static final Set<String> OPERATORS = Set.of("+", "-", "*");

    // Metoda do obliczania wyrażenia RPN
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();// Tworzymy stos do przechowywania liczb zamiast Stringów
        String[] tokens = expression.split(" ");// Dzielimy wyrażenie na tokeny

        for (String token : tokens) {
            if (OPERATORS.contains(token)) { // Sprawdzamy, czy token jest operatorem
                int b = stack.pop();
                int a = stack.pop();
                // Stosujemy operator i wynik umieszczamy na stosie
                stack.push(switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> throw new IllegalArgumentException();// Wyrzucamy wyjątek, jeśli operator jest nieprawidłowy
                });
            } else {
                // Jeśli token jest liczbą, dodajemy go jako int na stos
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); // Zwracamy wynik końcowy
    }
}