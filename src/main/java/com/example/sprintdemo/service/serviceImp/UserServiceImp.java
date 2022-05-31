package com.example.sprintdemo.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.dao.UserDao;
import com.example.sprintdemo.dto.UserDto;
import com.example.sprintdemo.model.UserModel;
import com.example.sprintdemo.service.UserService;
import com.example.sprintdemo.validation.UserModelValidator;

@Service
public class UserServiceImp implements UserService{
	
	public UserDao userDao;   
	public UserModelValidator userModelValidator;
	@Override
	public List<UserModel> getList()
	{
		return this.userDao.findAll();
	}
	@Override
	public UserModel save(UserModel user) {
		this.userModelValidator.validate(user);
		return this.userDao.save(user);
	}
	@Override
	public UserModel findUserById(Integer userId) {
		return this.userDao.findUserById(userId);
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
