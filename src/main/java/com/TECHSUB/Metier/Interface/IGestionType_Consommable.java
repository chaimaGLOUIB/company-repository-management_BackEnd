package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.TypeConsommable;

public interface IGestionType_Consommable {
	public List<TypeConsommable> getAllTypeConsommables();
	public Page<TypeConsommable> getPageTypeConsommables(int page ,int size);
	public TypeConsommable getTypeConsommable(Long id);
	public TypeConsommable addTypeConsommable(TypeConsommable e);
	public TypeConsommable updateTypeConsommable(Long id,TypeConsommable e);
	public void deleteTypeConsommable(Long id);
}
