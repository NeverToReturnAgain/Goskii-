package com.rj.bd.lease;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @desc   
 * @author dell
 * @time   2019年12月28日
 */
public interface LeaseService {

	List<Map<String, Object>> queryAll(String lease_brand, String lease_color, String lease_price, String lease_percent) throws ClassNotFoundException, SQLException;

	void addLease(String lease_id,String lease_introduction, String lease_img, String lease_brand, String lease_price,
			String lease_percent, String lease_color) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void addLeaseInfo(String lease_id, String user_mail) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void deleteLeaseInfo(String lease_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
