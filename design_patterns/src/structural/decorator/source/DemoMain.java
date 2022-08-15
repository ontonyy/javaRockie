package structural.decorator.source;

public class DemoMain {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        SourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/output_demo.txt")), 6);
        encoded.writeData(salaryRecords);
        System.out.println(encoded.readData());
    }
}
