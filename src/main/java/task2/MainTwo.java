package task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/more-age")
public class MainTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chelovekAge = req.getParameter("age");

        if (chelovekAge != null && chelovekAge.matches("\\d+")) {
            int age = Integer.parseInt(chelovekAge);
            String result = (age >= 18) ? "совершеннолетний" : "несовершеннолетний";

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h2>Результат проверки возраста:</h2>");
            out.println("<p>Возраст: " + age + "</p>");
            out.println("<p>Результат: " + result + "</p>");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный возраст");
        }
    }
}
