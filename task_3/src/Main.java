import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        int count = 0;
        students = fillArray(4);
        printArray(students);
        calc3(students, count);
        System.out.println("Count = " + count);
    }

    static void calc3(Student[] st, int count) {
        for (Student student : st) {
            if (student.ifGrade == 5 && student.mathGrade == 5 && student.physicsGrade == 5) {
                count++;
            }
        }
    }

    static Student[] fillArray(int size) {
        Student[] st = new Student[size];
        Random rand = new Random();
        String[] name = { "Oleg", "Andrew", "Mykola","Igor" };
        String[] spec = { "SS", "IN", "KV", "SD", "UG", "TR" };
        for (int i = 0; i < size; i++) {
            int randValue = rand.nextInt(name.length);
            int randValue2 = rand.nextInt(spec.length);
            st[i] = new Student();
            st[i].surname = name[randValue];
            st[i].course = rand.nextInt(4) + 1;
            st[i].specialty = spec[randValue2];
            st[i].ifGrade = rand.nextInt(5) + 1;
            st[i].mathGrade = rand.nextInt(5) + 1;
            st[i].physicsGrade = rand.nextInt(5) + 1;
        }
        return st;
    }

    static void printArray(Student[] st) {
        System.out.println("--------------------------------------");
        System.out.println("Surname | course |  Spec  |  IFG |  MTG  |  PSG  |");
        for (Student student : st) {
            System.out.println("-----------------------------------");
            System.out.println(student.surname + "\t|\t" + student.course + "|\t" + student.specialty + "|\t" + student.ifGrade + "|\t" + student.mathGrade + "|\t" + student.physicsGrade + "|");
        }
        System.out.println("--------------------------------------");
    }

    public static class Student {
        public String surname; // прізвище студента
        public int course; // курс
        public String specialty; // спеціальність
        public int physicsGrade; // оцінка з фізики
        public int mathGrade; // оцінка з математики
        public int ifGrade; // оцінка з інформатики
    }
}
