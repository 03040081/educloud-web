package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.OrderInfo;
import zsc.gof.entity.Schedule;
import zsc.gof.entity.User;

public interface UserBiz {

	public int SignUp(User user);
	
	public User Login(User user);
	
	public List<OrderInfo> listOrder(int userId);
	
	public int SubmitOrder(OrderInfo orderInfo);
	
	public void CompltetOrder(int orderId);
	
	public boolean addSchedule(Schedule schedule);
	
	public List<Schedule> getUserSchedule(int userId);
}
