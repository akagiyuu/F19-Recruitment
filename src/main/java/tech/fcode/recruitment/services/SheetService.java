package tech.fcode.recruitment.services;
import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;

public interface SheetService {
    void exportSheet(HttpServletResponse response) throws IOException;
}
