class Freelancer extends Employee {
    private double hourlyRate;

    public Freelancer(String name, int age, double hourlyRate) {
        super(name, age);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Freelancer{name='%s', age=%d, hourlyRate=%.2f, salary=%.2f}", getName(), getAge(), hourlyRate, calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = generateEmployees(5);
        System.out.println("Before sorting:");
        employees.forEach(System.out::println);

        Collections.sort(employees, Comparator.comparingInt(Employee::getAge));

        System.out.println("\nAfter sorting by age:");
        employees.forEach(System.out::println);
    }

    private static List<Employee> generateEmployees(int num) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < num; i++) {
            int type = random.nextInt(3); // 0 - Worker, 1 - Freelancer, 2 - Employee
            String name = "Employee" + i;
            int age = 20 + random.nextInt(30); // Age between 20 and 50

            switch (type) {
                case 0:
                    double hourlyRate = 10 + random.nextDouble() * 20; // Hourly rate between 10 and 30
                    employees.add(new Worker(name, age, hourlyRate));
                    break;
                case 1:
                    double freelancerRate = 15 + random.nextDouble() * 25; // Hourly rate between 15 and 40
                    employees.add(new Freelancer(name, age, freelancerRate));
                    break;
                default:
                    employees.add(new Employee(name, age));
                    break;
            }
        }

        return employees;
    }
}