package task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//Создать приложение, которое при переходе на следующие урлы будет выдавать
//результат:
///minsk - время в Минске
///washington - время в Вашингтоне
///beijing - время в Пекине
//При решении использовать оба варианта настройки (xml и аннотации)
@WebServlet("/time")
public class MainOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city=req.getPathInfo().substring(1);
        String time;
        switch (city){
            case "minsk":
                time=getTimeInCity("Europe/Minsk");
                break;
            case "washington":
                time= getTimeInCity("America/New_York");
                break;
            case "beijing":
                time = getTimeInCity("Asia/Shanghai");
                break;
            default:
                time = "Unknown city";
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Current time in " + city + ": " + time + "</h2>");
    }
    private String getTimeInCity(String timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone(timeZone));
        return sdf.format(new Date());
    }
}
