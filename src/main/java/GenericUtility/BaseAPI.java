package GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPI {
	public DataBaseUtils dataBaseUtils = new DataBaseUtils();
	@BeforeSuite
	public void connectionToDb() throws SQLException{
		dataBaseUtils.connectToDb();	
	}
	@AfterSuite
	public void disconnectToDb() throws SQLException{
		dataBaseUtils.disconnectToDb();
	}

}
