import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
    String username = "paolo";
    List<Device> deviceDao = new DeviceDao(username).getAllDeviceWIthHearthRateAndGps();
        for (Device dev : deviceDao){
            System.out.println(dev);
        }
    }
}