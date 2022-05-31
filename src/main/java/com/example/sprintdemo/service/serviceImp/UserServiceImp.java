package com.example.sprintdemo.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.dao.UserDao;
import com.example.sprintdemo.dto.UserDto;
import com.example.sprintdemo.model.UserModel;
import com.example.sprintdemo.service.UserService;
import com.example.sprintdemo.validation.UserModelValidator;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	public UserDao userDao;  
	@Autowired
	public UserModelValidator userModelValidator;
	@Override
	public List<UserModel> getList()
	{
		var user = userDao.findAll();
		return user;
	}
	@Override
	public UserModel save(UserModel user) {
		userModelValidator.validate(user);
		return this.userDao.save(user);
	}
	@Override
	public UserModel findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}
    private UserModel dtoToEntity(UserDto userDto) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
    
    private List<UserDto> dtoToListEntity(List<UserModel> listUserDto)
    {
    	List<UserDto> listUser = new ArrayList<UserDto>();
        BeanUtils.copyProperties(listUserDto, listUser);
        return listUser;
    }
}
