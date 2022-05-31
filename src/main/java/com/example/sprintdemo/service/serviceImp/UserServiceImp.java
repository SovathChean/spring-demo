package com.example.sprintdemo.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<UserDto> getList()
	{
		var users = userDao.findAll();
		return users.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
	}
	@Override
	public UserDto save(UserDto userDto) {
		userModelValidator.validate(userDto);
		UserModel user = this.dtoToEntity(userDto);
	    userDao.save(user);
		return new UserDto(user);
	}
	@Override
	public UserDto findUserById(Integer userId) {
		UserModel user =  userDao.findUserById(userId).orElseThrow(() -> new com.example.sprintdemo.exception.ResourceNotFoundException(userId));
		return new UserDto(user);
	}
    private UserModel dtoToEntity(UserDto userDto) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}
