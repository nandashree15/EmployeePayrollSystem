public class Employee {

    private int empId;
    private String empName;
    private double basicSalary;

    public Employee(int empId, String empName, double basicSalary) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
    }

    public double calculateHRA() {
        return basicSalary * 0.20;
    }

    public double calculateDA() {
        return basicSalary * 0.10;
    }

    public double calculateNetSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    public void display() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Basic Salary: " + basicSalary);
    }

    public void display(boolean showNet) {
        display();
        if(showNet) {
            System.out.println("HRA: " + calculateHRA());
            System.out.println("DA: " + calculateDA());
            System.out.println("Net Salary: " + calculateNetSalary());
        }
    }

    public String toFileString() {
        return empId + "," + empName + "," + basicSalary;
    }
}