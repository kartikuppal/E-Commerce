package com.infogain.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infogain.app.dto.BrandDto;
import com.infogain.app.exception.InvalidInputException;
@Service
public interface IBrandService {
	public BrandDto insert(BrandDto brandDto) throws InvalidInputException;
	public List<BrandDto> displayAll();
	public BrandDto displayById(Integer id);
	public BrandDto update(BrandDto brandDto) throws InvalidInputException;
	public void delete(Integer id);
}
