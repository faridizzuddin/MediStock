
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})

public class SendEmail extends HttpServlet {

    String productName, companyName, supplierName, email, subject, status;
    int quantity, productID;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        productID = Integer.parseInt(request.getParameter("prID"));
        productName = request.getParameter("prName");
        companyName = request.getParameter("company");
        supplierName = request.getParameter("suppName");
        email = request.getParameter("email");
        quantity = Integer.parseInt(request.getParameter("quantity"));
        subject = "Order request from MediStock Co.";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("faridizzuddinn@gmail.com", "cvih nrar yjts ysid");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            MimeBodyPart textPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String final_Text = "Dear " + supplierName + "\n\nI hope this message finds you well\n\nProduct Name : " + productName + "\nQuantity : " + quantity + ""
                    + "\n\nPlease confirm the availability and probide an estimated ddelivery date. "
                    + "Additionally, if there are any forms or further details required to process this order, kindly let me know."
                    + "\n\nThank you for your attention to this metter. "
                    + "I look forward to yout prompt response."
                    + "\n\nBest regards,"
                    + "\nMediStock Co.";
            textPart.setText(final_Text);
            message.setSubject(subject);
            multipart.addBodyPart(textPart);
            message.setContent(multipart);
            message.setSubject("Contact Details");
            //out.println("Sending");
            Transport.send(message);
            status = "Thank you MediStock Co. your message has been submitted to us.";
        } catch (Exception e) {
            out.println(e);
        }
        request.setAttribute("status", status);
        request.getRequestDispatcher("completeOrder.jsp").forward(request, response);

    }

}
