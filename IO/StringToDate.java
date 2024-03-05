package IO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToDate {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    String text = date.format(formatter);
    LocalDate parsedDate = LocalDate.parse(text, formatter);
}
