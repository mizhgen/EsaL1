package servlets;

import beans.AddressBean;
import beans.EventBean;
import entities.Address;
import entities.Event;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    @EJB
    private EventBean eventBean;
    @EJB
    private AddressBean addressBean;

    @PersistenceContext(unitName = "esa")
    private EntityManager em;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String date = request.getParameter("date");

        String TIME_FORMAT = "HH:mm";

        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());

        Time time = null;
        try {
            time = new Time(timeFormat.parse(request.getParameter("time")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String building = request.getParameter("building");

        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setBuilding(building);
        Address newAddress = addressBean.add(address);

        Event event = new Event();
        event.setAddress(newAddress);
        event.setTitle(title);
        event.setDate(Date.valueOf(date));
        event.setTime(time);
        eventBean.add(event);
        response.sendRedirect(request.getContextPath());
    }
}
