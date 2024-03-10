class Employee implements Payable {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public double calculateSalary() {
        return 0; // Default implementation for employees without specific salary calculation
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d}", name, age);
    }
}

class Worker extends Employee {
    private double hourlyRate;

    public Worker(String name, int age, double hourlyRate) {
        super(name, age);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Worker{name='%s', age=%d, hourlyRate=%.2f, salary=%.2f}", getName(), getAge(), hourlyRate, calculateSalary());
    }
}