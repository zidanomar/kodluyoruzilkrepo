public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary < 1000) {
            return 0;
        }
        return this.salary * 0.03;
    }

    public double bonus() {
        if (this.workHours > 40) {
            return (this.workHours - 40) * 30;
        }
        return 0;
    }

    public double raiseSalary() {
        int currentYear = 2021;
        int yearsWorked = currentYear - this.hireYear;
        if (yearsWorked < 10) {
            return this.salary * 0.05;
        } else if (yearsWorked < 20) {
            return this.salary * 0.10;
        } else {
            return this.salary * 0.15;
        }
    }

    @Override
    public String toString() {
        double taxAmount = tax();
        double bonusAmount = bonus();
        double raiseAmount = raiseSalary();
        double salaryWithExtras = this.salary - taxAmount + bonusAmount;
        double totalSalary = salaryWithExtras + raiseAmount;

        return "Adı : " + this.name + "\n" +
               "Maaşı : " + this.salary + "\n" +
               "Çalışma Saati : " + this.workHours + "\n" +
               "Başlangıç Yılı : " + this.hireYear + "\n" +
               "Vergi : " + taxAmount + "\n" +
               "Bonus : " + bonusAmount + "\n" +
               "Maaş Artışı : " + raiseAmount + "\n" +
               "Vergi ve Bonuslar ile birlikte maaş : " + salaryWithExtras + "\n" +
               "Toplam Maaş : " + totalSalary;
    }
}
