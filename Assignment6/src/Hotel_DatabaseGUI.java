import javax.naming.Name;
import javax.swing.*;
import java.sql.*;

public class Hotel_DatabaseGUI {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    private JPanel panel1;
    private JLabel reservationIDLabel;
    private JButton searchButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JTextField resTxtF;
    private JTextField nameTxtF;
    private JTextField numGTxtF;
    private JTextField roomNTxtF;
    private JLabel nameLabel;
    private JLabel NoGLabel;
    private JLabel RoomNLabel;

    private void createUIComponents() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/Module8", "postgres", "CDohs23#");
            ps = conn.prepareStatement("SELECT * FROM hotel_res where id =?");
            rs = ps.executeQuery();
            while (rs.next());

            resTxtF.setText(rs.getString("Reservation ID"));
            nameTxtF.setText(String.valueOf(rs.getInt("Name")));
            numGTxtF.setText(String.valueOf(rs.getInt("Number of Guests")));
            roomNTxtF.setText(String.valueOf(rs.getInt("Room Number")));
            System.out.println();
            rs.close();

        } catch (SQLException e) {
        }
    }
}