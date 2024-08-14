public class TaxPayer {


    private double annualSalaryIncome;
    private double annualServiceIncome;
    private double annualCapitalIncome;
    private double medicalExpenses;
    private double educationalExpenses;

    public TaxPayer(double annualSalaryIncome, double annualServiceIncome, double annualCapitalIncome, double medicalExpenses, double educationalExpenses) {
        this.annualSalaryIncome = annualSalaryIncome;
        this.annualServiceIncome = annualServiceIncome;
        this.annualCapitalIncome = annualCapitalIncome;
        this.medicalExpenses = medicalExpenses;
        this.educationalExpenses = educationalExpenses;
    }


    public double getAnnualSalaryIncome() {
        return annualSalaryIncome;
    }

    public void setAnnualSalaryIncome(double annualSalaryIncome) {
        this.annualSalaryIncome = annualSalaryIncome;
    }

    public double getAnnualServiceIncome() {
        return annualServiceIncome;
    }

    public void setAnnualServiceIncome(double annualServiceIncome) {
        this.annualServiceIncome = annualServiceIncome;
    }

    public double getAnnualCapitalIncome() {
        return annualCapitalIncome;
    }

    public void setAnnualCapitalIncome(double annualCapitalIncome) {
        this.annualCapitalIncome = annualCapitalIncome;
    }

    public double getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(double medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    public double getEducationalExpenses() {
        return educationalExpenses;
    }

    public void setEducationalExpenses(double educationalExpenses) {
        this.educationalExpenses = educationalExpenses;
    }


    private double salaryTax() {
        double monthlySalary = annualSalaryIncome / 12.0;
        if (monthlySalary < 3000) {
            return 0;
        } else if (monthlySalary < 5000) {
            return annualSalaryIncome * 0.10;
        } else {
            return annualSalaryIncome * 0.20;
        }
    }


    private double serviceTax() {
        return annualServiceIncome * 0.15;
    }


    private double capitalTax() {
        return annualCapitalIncome * 0.20;
    }


    public double grossTax() {
        return salaryTax() + serviceTax() + capitalTax();
    }


    public double taxRebate() {
        double maxRebate = grossTax() * 0.30;
        double totalExpenses = medicalExpenses + educationalExpenses;
        return Math.min(maxRebate, totalExpenses);
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }
}
