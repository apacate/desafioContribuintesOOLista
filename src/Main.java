import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite os dados do " + i + "o contribuinte:");

            System.out.print("Renda anual com salário: ");
            double annualSalaryIncome = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            double annualServiceIncome = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            double annualCapitalIncome = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            double medicalExpenses = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            double educationalExpenses = sc.nextDouble();

            TaxPayer taxpayer = new TaxPayer(annualSalaryIncome, annualServiceIncome, annualCapitalIncome, medicalExpenses, educationalExpenses);
            taxPayers.add(taxpayer);
        }

        for (int i = 0; i < taxPayers.size(); i++) {
            TaxPayer taxpayer = taxPayers.get(i);
            System.out.println("Resumo do " + (i + 1) + "o contribuinte:");
            System.out.printf("Imposto bruto total: %.2f%n", taxpayer.grossTax());
            System.out.printf("Abatimento: %.2f%n", taxpayer.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxpayer.netTax());
        }

        sc.close();
    }
}