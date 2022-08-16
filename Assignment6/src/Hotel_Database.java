import javax.swing.*;
import java.sql.*;

public class Hotel_Database extends JPanel {
    public static void main(String[] args) throws RuntimeException{


        Statement stmt = null;
        Connection conn = null;

        try {
            //Connecting to Postgres Database
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/Module8", "postgres", "CDohs23#");
            System.out.println("Connected to database");

            stmt = conn.createStatement();

            // Creates a table for Hotel Reservation Data
            stmt.execute("CREATE TABLE hotel_res (name varchar(25), res_id int, num_guest int, room_num int)");
            System.out.println("Hotel Reservation table successfully created");

            //Adding records
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('George Lopez', 30478, 2, 1)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES ('Louis CK', 29358, 3, 2)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Adam Sandler', 76011, 4, 3)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES ('Kevin Hart',95985, 5, 4)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Katt Williams', 12247, 1, 5)");

            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Amy Schumer', 39463, 5, 6)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Will Smith', 11922, 3, 7)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Chris Rock', 68508, 2, 8)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('John Mulaney', 90548, 2, 9)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Bill Burr', 27995, 1, 10)");

            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Jerry Seinfield', 45293, 3, 11)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Jim Carey', 73399, 2, 12)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('David Spade', 28850, 3, 13)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Eddie Murphy', 45991, 3, 14)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Seth Rogan', 71885, 1, 15)");

            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Melissa McCarthy', 95921, 4, 16)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Seth MacFarlane', 23056, 1, 17)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Anna Faris', 55691, 3, 18)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Rebel Wilson', 88819, 2, 19)");
            stmt.executeUpdate("INSERT INTO hotel_res VALUES('Leslie Mann', 70948, 4, 20)");

            System.out.println("20 rows successfully inserted.");


        } catch (SQLException e) {
            System.out.println("Error connecting to database:" + e.getMessage());
        }

        finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }

        }

    }
    //Creating GUI

    private JPanel panel1;
    private JLabel reservationIDLabel;
    private JButton searchButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JTextField resTxtF;
    private JTextField nameTxtF;
    private JTextField numGTxtF;
    private JTextField roomNTxtF;

    //Selecting Records
    public static void records() throws SQLException {
        ResultSet rs = null;
        try {
            Statement stmt = null;
            rs = stmt.executeQuery("SELECT * FROM hotel_res");
            if (rs.isBeforeFirst()) {

                while (rs.next()) {

                    String name = rs.getString("name");
                    int res_id = rs.getInt("res_id");
                    int num_guests = rs.getInt("num_guests");
                    int room_num = rs.getInt("room_num");

                    System.out.println("Name:" + name);
                    System.out.println("Reservation ID:" + res_id);
                    System.out.println("Number of guests:" + num_guests);
                    System.out.println("Room Number: " + room_num);
                }
            } else {
                System.out.println("No Records selected.");
            }
        } finally {
            try {
                rs.close();
            } catch (Exception e) {

            }
        }
    }

}

