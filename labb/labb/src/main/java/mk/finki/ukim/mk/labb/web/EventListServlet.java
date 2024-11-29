package mk.finki.ukim.mk.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventListServlet", urlPatterns = "/home")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;
    private final SpringTemplateEngine templateEngine;

    // Конструктор за инјектирање на зависности
    public EventListServlet(EventService eventService, SpringTemplateEngine templateEngine) {
        this.eventService = eventService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Конфигурирање на контекст за Thymeleaf
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);


        List<Event> eventList = eventService.listAll();

        // Додавање атрибути во контекстот за користење на JSP/HTML страната
        context.setVariable("events", eventList);
        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("userAgent", req.getHeader("user-agent"));

        // Рендерирање на страната со Thymeleaf
        templateEngine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка на корисничкиот избор и број на карти
        String eventName = req.getParameter("eventName");
        int numTickets = Integer.parseInt(req.getParameter("numTickets"));

        // Пренасочување кон страната за резервација
        resp.sendRedirect("/eventBooking?eventName=" + eventName + "&numTickets=" + numTickets);
    }
}
