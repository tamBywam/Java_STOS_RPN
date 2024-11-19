import java.util.Set;

public class RPNCalculator {
    // Zestaw operatorów dla łatwego sprawdzenia
    private static final Set<String> OPERATORS = Set.of("+", "-", "*");

    // Metoda do obliczania wyrażenia RPN
    public int evaluate(String expression) {
        Stack stack = new Stack(); // Tworzymy stos (nasza własna implementacja)
        String[] tokens = expression.split(" "); // Dzielimy wyrażenie na tokeny

        for (String token : tokens) {
            if (OPERATORS.contains(token)) { // Sprawdzamy, czy token jest operatorem
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                // Stosujemy operator i wynik umieszczamy na stosie
                int result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> throw new IllegalArgumentException(); // Wyrzucamy wyjątek, jeśli operator jest nieprawidłowy
                };
                stack.push(String.valueOf(result)); // Wynik zamieniamy na String przed dodaniem na stos
            } else {
                // Jeśli token jest liczbą, dodajemy go jako String na stos
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop()); // Zwracamy wynik końcowy jako int
    }
}
