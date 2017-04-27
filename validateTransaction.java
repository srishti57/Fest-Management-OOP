package spree;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validateTransaction")
public class validateTransaction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String cardType = request.getParameter("cardType");
        String Type = request.getParameter("Type");
        String cardNo = request.getParameter("cardNo");
        String name = request.getParameter("name");
        String expiryMonth = request.getParameter("expiryMonth");
        String expiryYear = request.getParameter("expiryYear");
        String cvv = (request.getParameter("cvv"));
        if(cardType == null | Type == null | cardNo == null | name == null | expiryMonth == null | expiryYear == null | cvv == null){
//        	Finance bean = (Finance)(request.getAttribute("amountToBePaid"));
//        	request.setAttribute("amountToBePaid", bean);
//        	System.out.println(bean.getBalance());
//    	    RequestDispatcher dispatcher =
          	      response.sendRedirect("TransactionFailed.jsp");
        }
        else{
        	HttpSession session = request.getSession();
        	int amount = ((Finance)(session.getAttribute("amountToBePaid"))).getBalance();
        	Finance.updateFinance(amount);
    		response.sendRedirect("ThankYouForReg.jsp");
        }
    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
      doGet(request, response);
    }
}
