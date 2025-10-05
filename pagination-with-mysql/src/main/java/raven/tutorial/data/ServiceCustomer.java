package raven.tutorial.data;

import raven.tutorial.connection.DatabaseConnection;
import raven.tutorial.pagination.ResponsePageable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCustomer {

    private final int LIMIT = 50;

    public ResponsePageable<List<ModelCustomer>> getAll(int page) throws SQLException {
        int total = getCount();
        int pageSize = (int) Math.ceil((double) total / LIMIT);
        int start = Math.min((page - 1) * LIMIT, total);
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement(GET_ALL);
            p.setInt(1, start);
            p.setInt(2, LIMIT);
            r = p.executeQuery();
            List<ModelCustomer> list = new ArrayList<>();
            while (r.next()) {
                int customerId = r.getInt("CustomerID");
                String firstName = r.getString("FirstName");
                String lastName = r.getString("LastName");
                String company = r.getString("Company");
                String city = r.getString("City");
                String country = r.getString("Country");
                String email = r.getString("Email");
                Date subscriptionDate = r.getDate("SubscriptionDate");
                String website = r.getString("Website");
                list.add(new ModelCustomer(customerId, firstName, lastName, company, city, country, email, subscriptionDate, website));
            }
            return new ResponsePageable<>(total, page, pageSize, LIMIT, list);
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public int getCount() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement(GET_COUNT);
            r = p.executeQuery();
            int total = 0;
            if (r.next()) {
                total = r.getInt(1);
            }
            return total;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    private final String GET_ALL = "select * from customer limit ?,?";
    private final String GET_COUNT = "select count(*) from customer";
}
