package zsc.gof.biz.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.UserBiz;
import zsc.gof.dao.UserDao;
import zsc.gof.entity.OrderInfo;
import zsc.gof.entity.Schedule;
import zsc.gof.entity.User;

@Service
public class UserBizImpl implements UserBiz{

	@Autowired
	UserDao dao;

	@Override
	public int SignUp(User user) {
		// TODO Auto-generated method stub
		return dao.SignUp(user);
	}

	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		return dao.Login(user);
	}

	@Override
	public List<OrderInfo> listOrder(int userId) {
		// TODO Auto-generated method stub
		return dao.ListOrderInfo(userId);
	}

	@Override
	public int SubmitOrder(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return dao.SubmitOrder(orderInfo);
	}

	@Override
	public void CompltetOrder(int orderId) {
		// TODO Auto-generated method stub
		dao.CompleteOrder(orderId);
	}

	@Override
	public boolean addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return dao.addSchedule(schedule);
	}

	@Override
	public List<Schedule> getUserSchedule(int userId) {
		// TODO Auto-generated method stub
		return dao.getUserSchedule(userId);
	}
	
	
}
