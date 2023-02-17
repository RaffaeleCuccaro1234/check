import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "J6q2rM62b11%B2D%CMzY");
    public DeviceDao(String username) throws SQLException {}
    public List<Device> getAllDeviceWIthHearthRateAndGps() throws SQLException {
        Statement statement = connection.createStatement();List<Device> list =new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM device WHERE device_has_heartrate != 0 AND DEVICE_HAS_GPS != 0 AND username = \"paolo\"");
        while (resultSet.next())
        {
            Device device = new Device();
            device.setDevicePartNumber(resultSet.getString("device_part_number"));
            device.setDeviceHasGps(Short.parseShort(resultSet.getString("device_has_gps")));
            device.setDeviceHasHeartRate(Short.parseShort(resultSet.getString("device_has_HeartRate")));
            device.setDeviceManufacturer(resultSet.getString("device_manufacturer"));
            device.setUsername(resultSet.getString("username"));
            device.setDeviceModel(resultSet.getString("device_model"));
            list.add(device);
        }


        return list;
    }



}
