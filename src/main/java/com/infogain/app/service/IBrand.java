package com.infogain.app.service;

import java.util.List;
import com.infogain.app.entity.Brand;
import com.infogain.app.exception.CustomException;

public interface IBrand {

	public Brand insertBrand(Brand brand) throws CustomException;
	public List<Brand> displayAllBrands();
	public Brand displayBrandById(Integer id);
	public Brand updateBrand(Brand updatedBrand, Integer id) throws CustomException;
	public void deleteBrand(Integer id);
}
