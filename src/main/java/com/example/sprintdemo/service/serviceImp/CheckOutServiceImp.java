package com.example.sprintdemo.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.dao.CheckOutDao;
import com.example.sprintdemo.dto.CheckOutDto;
import com.example.sprintdemo.dto.CheckOutProductsDto;
import com.example.sprintdemo.model.CheckOutModel;
import com.example.sprintdemo.model.CheckOutProducts;
import com.example.sprintdemo.service.CheckOutService;
import com.example.sprintdemo.validation.CheckOutModelValidator;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CheckOutServiceImp implements CheckOutService{

	@Autowired
	public CheckOutDao checkoutDao;
	@Autowired
	public CheckOutModelValidator checkoutValidator;
	@Override
	public CheckOutDto save(CheckOutDto ckDto) {
		CheckOutModel ckModel = this.dtoToEntity(ckDto);
		checkoutDao.save(ckModel);
		return new CheckOutDto(ckModel);
	}

    private CheckOutModel dtoToEntity(CheckOutDto ckDto) {
    	CheckOutModel ckOut = new CheckOutModel();
        List<CheckOutProducts> ckOutProduct = new ArrayList<>();

        BeanUtils.copyProperties(ckDto, ckOut, "ckProducts");
        
        List<CheckOutProductsDto> ckDtoList = ckDto.getProducts();

        if(ckDtoList != null && ckDtoList.size() > 0) {
        	ckDtoList.forEach(product -> {
                CheckOutProducts ckProduct = new CheckOutProducts();
                BeanUtils.copyProperties(product, ckProduct);
                ckProduct.setCheckout(ckOut);
                ckOutProduct.add(ckProduct);
            });
        }
        ckOut.setProducts(ckOutProduct);
        return ckOut;
    }
}
