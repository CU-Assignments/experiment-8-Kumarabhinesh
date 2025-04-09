<%@ page language="java" %>
<html>
<head><title>Student Attendance</title></head>
<body>
    <form action="AttendanceServlet" method="post">
        Student ID: <input type="text" name="studentId"><br><br>
        Date: <input type="date" name="date"><br><br>
        Status:
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
