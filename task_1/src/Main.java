import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Встановлення діапазону значень
        final int minVal = 15;
        final int maxVal = 85;

        // Створення генератора випадкових чисел
        Random rand = new Random();

        // Створення масиву з 21 елементом
        int[] array = new int[21];

        // Заповнення масиву випадковими числами
        fillArray(array, rand, minVal, maxVal);

        // Виведення масиву на екран
        System.out.println("Початковий масив:");
        printArray(array);

        // Сортування масиву за зростанням
        java.util.Arrays.sort(array);

        // Обчислення кількості та суми елементів, що задовольняють критерію
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && i % 13 != 0) {
                count++;
                sum += array[i];
                array[i] = 0;
            }
        }

        // Виведення кількості та суми на екран
        System.out.println("Count elements: " + count);
        System.out.println("Сума елементiв, що задовольняють критерiю: " + sum);

        // Виведення модифікованого масиву на екран
        System.out.println("Модифiкований масив:");
        printArray(array);
    }

    // Метод для заповнення масиву випадковими числами
    static void fillArray(int[] array, Random rand, int minVal, int maxVal) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxVal - minVal + 1) + minVal;
        }
    }

    // Метод для виведення масиву на екран
    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3d", array[i]);
        }

        System.out.println();
    }
}
