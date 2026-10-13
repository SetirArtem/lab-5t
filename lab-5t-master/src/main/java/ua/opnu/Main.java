package ua.opnu;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування Завдання 1 (TimeSpan) ===");
        TimeSpan span1 = new TimeSpan(2, 30);
        System.out.println("Початковий інтервал: " + span1);
        span1.add(1, 45);
        System.out.println("Після add(1, 45): " + span1);
        span1.scale(2);
        System.out.println("Після scale(2): " + span1);
        System.out.println("Загальна тривалість у годинах: " + span1.getTotalHours());
        System.out.println("Загальна тривалість у хвилинах: " + span1.getTotalMinutes());

        System.out.println("\n=== Тестування Завдання 2 (Ієрархія Person) ===");
        // Висхідне перетворення (Upcasting)
        Person person = new Person("Шевченко", "Тарас", 47);
        Person student = new Student("Коваленко", "Олексій", 19, "АІ-253", "KB12345678");
        Person lecturer = new Lecturer("Годовиченко", "Микола", 42, "Інформаційні технології", 25000.0);

        // Масив типу Person, що містить об'єкти Person, Student, Lecturer
        Person[] people = new Person[] {
                person,
                student,
                lecturer,
                new Student("Бондаренко", "Марія", 18, "АІ-253", "KB87654321")
        };

        // Поліморфний виклик методу toString() через цикл
        for (Person p : people) {
            System.out.println(p);
        }
    }
}