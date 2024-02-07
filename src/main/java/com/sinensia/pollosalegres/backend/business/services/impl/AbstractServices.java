package com.sinensia.pollosalegres.backend.business.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractServices {
	
	@Autowired
	protected DozerBeanMapper mapper;
	
	protected <T, R> List<R> convertList(List<T> list, Class<R> classToConvert) {
		
		return list.stream()
				.map(x -> mapper.map(x, classToConvert))
				.toList();
	}
}
