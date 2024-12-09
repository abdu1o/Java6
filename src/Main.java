import java.time.temporal.ChronoUnit;
import java.time.*;
import java.util.function.*;

class Task1{
    public static void ProceedFunctions() {

        Function<Integer, Boolean> isLeapYear = year ->
                (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("2024 is leap year: " + isLeapYear.apply(2024));

        BiFunction<LocalDate, LocalDate, Long> daysBetween = (date1, date2) ->
                ChronoUnit.DAYS.between(date1, date2);
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 1, 1);
        System.out.println("Days between " + date1 + " and " + date2 + ": " + daysBetween.apply(date1, date2));

        BiFunction<LocalDate, LocalDate, Long> fullWeeksBetween = (start, end) ->
                ChronoUnit.WEEKS.between(start, end);
        System.out.println("Full weeks between " + date1 + " and " + date2 + ": " + fullWeeksBetween.apply(date1, date2));

        Function<LocalDate, DayOfWeek> dayOfWeek = date -> date.getDayOfWeek();
        LocalDate moonLanding = LocalDate.of(2006, 6, 18);
        System.out.println("Day of the week for " + moonLanding + ": " + dayOfWeek.apply(moonLanding));
    }
}

class Task2{
    public static void ProceedFunctions() {
        Function<int[], Integer> maxOfFour = numbers -> {
            if (numbers.length != 4) {
                throw new IllegalArgumentException("Need 4 numbers");
            }
            int max = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
            return max;
        };

        Function<int[], Integer> minOfFour = numbers -> {
            if (numbers.length != 4) {
                throw new IllegalArgumentException("Need 4 numbers");
            }
            int min = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < min) {
                    min = numbers[i];
                }
            }
            return min;
        };

        int[] inputNumbers = {7, 3, 9, 1};

        int max = maxOfFour.apply(inputNumbers);
        int min = minOfFour.apply(inputNumbers);

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}

class Task3 {
    public static void ProceedFunctions() {
        int[] numbers = {1, 2, 3, -3, -2, -1};

        int sumEqualTo = calculateSum(numbers, x -> x == 1);
        int sumOutOfRange = calculateSum(numbers, x -> x < 0 || x > 2);
        int sumPositive = calculateSum(numbers, x -> x > 0);
        int sumNegative = calculateSum(numbers, x -> x < 0);

        System.out.println("Sum of numbers equal: " + sumEqualTo);
        System.out.println("Sum of numbers out of range: " + sumOutOfRange);
        System.out.println("Sum of positive numbers: " + sumPositive);
        System.out.println("Sum of negative numbers: " + sumNegative);
    }

    private static int calculateSum(int[] numbers, Predicate<Integer> condition) {
        int sum = 0;
        for (int number : numbers) {
            if (condition.test(number)) {
                sum += number;
            }
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
//        Task1.ProceedFunctions();
//        Task2.ProceedFunctions();
        Task3.ProceedFunctions();
    }
}