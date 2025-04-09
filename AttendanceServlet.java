import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "root", "password");

            String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                out.println("<h2>Attendance recorded successfully!</h2>");
            } else {
                out.println("<h2>Failed to record attendance.</h2>");
            }
            conn.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
