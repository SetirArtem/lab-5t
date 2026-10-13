package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // 1. Конструктор без аргументів
    public TimeSpan() {
        this(0, 0);
    }

    // 2. Конструктор з одним аргументом (хвилини)
    public TimeSpan(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Кількість хвилин не може бути від'ємною");
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    // 3. Конструктор з двома аргументами (години та хвилини)
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні значення: hours >= 0, 0 <= minutes <= 59");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    // 4. Конструктор копіювання
    public TimeSpan(TimeSpan span) {
        if (span == null) {
            throw new IllegalArgumentException("Об'єкт TimeSpan не може бути null");
        }
        this.hours = span.getHours();
        this.minutes = span.getMinutes();
    }

    // Гетери
    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    // Перевантажені методи add()
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні аргументи для додавання");
        }
        int totalMinutes = this.getTotalMinutes() + (hours * 60 + minutes);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void add(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Кількість хвилин не може бути від'ємною");
        }
        int totalMinutes = this.getTotalMinutes() + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void add(TimeSpan span) {
        if (span != null) {
            this.add(span.getHours(), span.getMinutes());
        }
    }

    // Перевантажені методи subtract()
    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні аргументи для віднімання");
        }
        int toSubtract = hours * 60 + minutes;
        int currentTotal = this.getTotalMinutes();

        // Якщо інтервал більший за поточний, об'єкт не змінюється
        if (toSubtract <= currentTotal) {
            int remaining = currentTotal - toSubtract;
            this.hours = remaining / 60;
            this.minutes = remaining % 60;
        }
    }

    public void subtract(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Кількість хвилин не може бути від'ємною");
        }
        int currentTotal = this.getTotalMinutes();
        if (minutes <= currentTotal) {
            int remaining = currentTotal - minutes;
            this.hours = remaining / 60;
            this.minutes = remaining % 60;
        }
    }

    public void subtract(TimeSpan span) {
        if (span != null) {
            this.subtract(span.getHours(), span.getMinutes());
        }
    }

    // Повна тривалість
    public double getTotalHours() {
        return this.hours + (this.minutes / 60.0);
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    // Масштабування
    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("factor повинен бути більшим за 0");
        }
        int total = this.getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    @Override
    public String toString() {
        return hours + " годин " + minutes + " хвилин";
    }
}