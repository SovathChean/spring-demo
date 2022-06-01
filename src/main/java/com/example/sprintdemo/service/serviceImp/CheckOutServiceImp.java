package com.example.sprintdemo.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.dao.CheckOutDao;
import com.example.sprintdemo.dao.ProductDao;
import com.example.sprintdemo.dto.CheckOutDto;
import com.example.sprintdemo.dto.CheckOutProductsDto;
import com.example.sprintdemo.exception.ProductOutOfStock;
import com.example.sprintdemo.exception.ResourceNotFoundException;
import com.example.sprintdemo.model.CheckOutModel;
import com.example.sprintdemo.model.CheckOutProducts;
import com.example.sprintdemo.model.ProductModel;
import com.example.sprintdemo.service.CheckOutService;
import com.example.sprintdemo.validation.CheckOutModelValidator;


@Service
public class CheckOutServiceImp implements CheckOutService{

	@Autowired
	public CheckOutDao checkoutDao;
	@Autowired
	public ProductDao productDao;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	public CheckOutModelValidator checkoutValidator;
	@Override
	@Transactional
	public CheckOutDto save(CheckOutDto ckDto) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;  
		CheckOutModel ckModel = this.dtoToEntity(ckDto);
		List<ProductModel> productlList = new ArrayList<>();

        try
        {
        	tx = session.beginTransaction();  
			ckModel.getProducts().forEach(ckProduct -> {
				ProductModel product = productDao.findProductById(ckProduct.getProductId()).orElseThrow(() -> new ResourceNotFoundException(ckProduct.getProductId()));
				Integer deductQty = product.getQty() - ckProduct.getQty();
				if(deductQty < 0)
					throw new ProductOutOfStock(product.getProductName());
				product.setQty(deductQty);
				productlList.add(product);
			});
			productDao.saveAll(productlList);
			checkoutDao.save(ckModel);
			tx.commit();
        }
        catch(Exception e)
        {
        	if (tx != null) {
        	    tx.rollback();
        	}
        	throw e;
        }
	
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
