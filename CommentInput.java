import java.sql.*;
import java.util.Calendar;

public class CommentInput
{

    public static void main(String[] args)
    {
        try
        {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/comment";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "WAN1384-8");

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String query = " insert into comment (date, comment)"
                    + " values (?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDate (1, startDate);
            preparedStmt.setString   (2, "bi");

            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
