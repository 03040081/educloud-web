package zsc.gof.dao;

import java.util.List;

import zsc.gof.entity.OrderInfo;
import zsc.gof.entity.Schedule;
import zsc.gof.entity.User;
import zsc.gof.entity.VideoInfo;

public interface UserDao {

	/*
	 * 注册
	 */
	public int SignUp(User user);
	
	/*
	 * 登录
	 */
	public User Login(User user);
	
	/*
	 * 提交订单
	 */
	public int SubmitOrder(OrderInfo orderInfo);
	
	/*
	 * 完成订单（付款完成）
	 */
	public void CompleteOrder(int orderId);
	
	/*
	 * 个人订单信息
	 */
	public List<OrderInfo> ListOrderInfo(int userId);
	
	//public List<VideoInfo> OrderVideo(int userId);
	
	public VideoInfo OrderVideo(int videoId);
	
	public boolean addSchedule(Schedule schedule);
	
	public List<Schedule> getUserSchedule(int userId);
}
