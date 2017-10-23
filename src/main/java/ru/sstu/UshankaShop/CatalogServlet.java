package ru.sstu.UshankaShop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CatalogServlet extends HttpServlet {

    private static List<Item> items = Arrays.asList(
            new Item(0L,"Hat-Ushanka", "Warm and cozy", 99.99, 15),
    new Item(1L, "Varezhka", "Soft", 50.00, 15));

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
     if(req.getQueryString().equals("format=XML")) {
         JAXBContext context = JAXBContext.newInstance(ItemList.class);
         Marshaller marshaller = context.createMarshaller();
         marshaller.marshal(new ItemList(items), resp.getOutputStream());
     }
     } catch (JAXBException e) {
            e.printStackTrace();
        }


        resp.getOutputStream().print(items.toString());
    resp.getOutputStream().flush();
}
@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
}
}
