package com.rj.bd.lease;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

/**
 * @desc
 * @author dell
 * @time 2019年12月28日
 */
public class LeaseServiceImpl implements LeaseService {
	Dao dao = new DaoImpl();

	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 查询所有的租赁信息//还得改一下条件
	 */
	@Override
	public List<Map<String, Object>> queryAll(String lease_brand, String lease_color, String lease_price,
			String lease_percent) throws ClassNotFoundException, SQLException  {

		if (lease_brand == null)
			lease_brand = "";
		if (lease_color == null)
			lease_color = "";
		if (lease_price == null)
			lease_price = "";
		if (lease_percent == null)
			lease_percent = "";
		List<Map<String, Object>> list = dao.executeQueryForList("SELECT * FROM lease WHERE lease_brand LIKE '%"
				+ lease_brand + "%' AND lease_price LIKE '%" + lease_price + "%' AND lease_percent LIKE '%"
				+ lease_percent + "%'  AND lease_color LIKE '%" + lease_color + "%'"

		);

		return list;
	}

	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc   添加详细信息
	 */
	@Override
	public void addLease(String lease_id,String lease_introduction, String lease_img, String lease_brand, String lease_price,
			String lease_percent, String lease_color) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		
		String sql = "insert into lease values(?,?,?,?,?,?,?)";
		
		int[] types = new int[7];
		for (int i = 0; i < types.length; i++) types[i] = Types.VARCHAR; 
		
		Object[] values = {
				lease_id,
				lease_introduction,
				lease_img,
				lease_brand,
				lease_price,
				lease_percent,
				lease_color
				
		};
		dao.executeUpdate(sql , types , values );
		
	}

	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc  插入简洁信息
	 */
	@Override
	public void addLeaseInfo(String lease_id, String user_mail) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		String sql = "insert into lease_info values(?,?)";
		dao.executeUpdate(sql ,new int[]{Types.VARCHAR,Types.VARCHAR} , new Object[]{lease_id,user_mail});
		
		
	}

	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 删除租赁信息
	 */
	@Override
	public void deleteLeaseInfo(String lease_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("delete from lease_info where lease_id=?", new int[]{Types.VARCHAR}, new Object[]{lease_id});
		
		//在删除数据库信息之前还得先查询详细信息表里面的图片名字,并且用io删除
		dao.executeUpdate("delete from lease where lease_id=?", new int[]{Types.VARCHAR}, new Object[]{lease_id});
		
	}

}
