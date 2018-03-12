package zsc.gof.dao;

import java.util.List;

import zsc.gof.entity.OrderInfo;
import zsc.gof.entity.Schedule;
import zsc.gof.entity.User;
import zsc.gof.entity.VideoInfo;

public interface UserDao {

	/*
	 * ע��
	 */
	public int SignUp(User user);
	
	/*
	 * ��¼
	 */
	public User Login(User user);
	
	/*
	 * �ύ����
	 */
	public int SubmitOrder(OrderInfo orderInfo);
	
	/*
	 * ��ɶ�����������ɣ�
	 */
	public void CompleteOrder(int orderId);
	
	/*
	 * ���˶�����Ϣ
	 */
	public List<OrderInfo> ListOrderInfo(int userId);
	
	//public List<VideoInfo> OrderVideo(int userId);
	
	public VideoInfo OrderVideo(int videoId);
	
	public boolean addSchedule(Schedule schedule);
	
	public List<Schedule> getUserSchedule(int userId);
}
