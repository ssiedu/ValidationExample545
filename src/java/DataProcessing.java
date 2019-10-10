import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            //reading request
            String s1=request.getParameter("t1");
            String s2=request.getParameter("t2");
            boolean isWrong=false;
            //validate the data
            if(s1.length()==0){
                isWrong=true;
                request.setAttribute("nameErr", "Name Cant Be Blank");
            }
            
            try{
                int age=Integer.parseInt(s2);
            }catch(NumberFormatException e){
                request.setAttribute("ageErr", "Age Must Be A Number");
                isWrong=true;
            }
            
            if(isWrong==true){
                //response.sendRedirect("inputs.jsp");
                RequestDispatcher rd=request.getRequestDispatcher("inputs.jsp");
                rd.forward(request,response);
            }
            
            
            
            
            
            //process request (DB store)
            //response 
            out.println("You Are Registered With Following Details: ");
            out.println("Name "+s1);
            out.println("Age  "+s2);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
