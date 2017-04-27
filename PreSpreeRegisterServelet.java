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


/** * Servlet implementation class PreSpreeRegisterServelet */ 
@WebServlet("/RegisterServelet")
public class PreSpreeRegisterServelet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        int amountToBePaid = 0;
    	try {
    	  String informalEvent = request.getParameter("informalEvent");
//    	  System.out.println(informalEvent);
    	  String registerForAcco = request.getParameter("registerForAcco");
    	  if(registerForAcco!=null){
    		  if(registerForAcco.equals("clicked"))
    			  amountToBePaid += 500;
    	  }
    	  if(informalEvent!=null){
    		  if(!(informalEvent.equals("-1")))
    			  amountToBePaid += 150;
    	  }
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("retypePassword");
        String studentName = request.getParameter("studentName");
        String studentID = request.getParameter("studentID");
        String collegeName = request.getParameter("collegeName");
        String sport = (request.getParameter("MainSport"));
        String email = request.getParameter("email");
        String teamName = request.getParameter("teamName");
	  if(sport!=null){
		  if(!(sport.equals("-1")))
			  amountToBePaid += 250;
	  }
//        System.out.println(userName);
//        System.out.println(password);
//        System.out.println(password1);
//        System.out.println(studentName);
//        System.out.println(studentID);
//        System.out.println(collegeName);
//        System.out.println(sport);
//        System.out.println(email);
//        System.out.println(teamName);
        
        
        
        
        boolean found = false,found1 = false,found2 = false;
//        if(email!=null){
//        Pattern checkEmail = Pattern.compile("\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\b");
//  		Matcher matchEmail = checkEmail.matcher(email);
//  		found = !(matchEmail.find());
//    	}
        if(userName!=null){
        	found1 = (CheckDuplicateEntry.CheckDuplicateUsername(userName));
        }
        if(password!=null | password1!=null){
        	found2 = (!password1.equals(password));
        }
        if(found1|found2|userName == null|studentID == null|studentName==null|(found)){
        	response.sendRedirect("RegistrationError.jsp");
        	
        }
        else{

       spree.StudentDetail sd = new StudentDetail(studentID, studentName, collegeName, email);
        spree.Participant newParticipant = new Participant(userName, password, sd, null, null, null, true);
        int participantKey = AddToDatabase.AddToParticipantsDB(newParticipant);
        AddToDatabase.AddToTeamDB(Integer.parseInt(sport), teamName, collegeName,participantKey);
        	    HttpSession session = request.getSession();
        	    synchronized(session) {
        	      Finance bean = 
        	        (Finance)session.getAttribute("amountToBePaid");
        	      if (bean == null) {
        	        bean = new Finance(amountToBePaid);
        	        session.setAttribute("amountToBePaid",bean);
        	        response.sendRedirect("bankGateway.jsp");
        	      }
        	    }
        }
        
        }
        catch (Throwable theException) {
            response.sendRedirect("RegistrationError.jsp");
        }
        
    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
      doGet(request, response);
    }
}
