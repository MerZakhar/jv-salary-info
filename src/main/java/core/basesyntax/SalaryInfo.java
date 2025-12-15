package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        LocalDate firstDate = LocalDate.parse(dateFrom, FORMATTER);
        LocalDate lastDate = LocalDate.parse(dateTo, FORMATTER);

        StringBuilder salaryReport = new StringBuilder();
        salaryReport.append("Report for period ")
                .append(dateFrom)
                .append(" - ")
                .append(dateTo)
                .append(System.lineSeparator());

        for (String name : names) {
            int fullSalary = 0;
            for (String info : data) {
                String[] parts = info.split(" ");
                if (name.equals(parts[1])) {
                    LocalDate date = LocalDate.parse(parts[0], FORMATTER);
                    if (!date.isBefore(firstDate) && !date.isAfter(lastDate)) {
                        fullSalary += Integer.parseInt(parts[2]) * Integer.parseInt(parts[3]);
                    }
                }
            }
            salaryReport.append(name)
                    .append(" - ")
                    .append(fullSalary)
                    .append(System.lineSeparator());
        }
        return salaryReport.toString().trim();
    }
}
