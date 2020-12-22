package com.contazap.abrigo_animal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

	private T data;
	private List<T> dataList;
	private List<String> errors;

	@SuppressWarnings("unchecked")
	// Conversor incompleto
	public static <T> List<T> convertList(List<?> listGeneric, Class<T> c) {

		System.out.println("Class: " + listGeneric.get(0).getClass());
		System.out.println("Class: " + c.getName());

		List<T> result = new ArrayList<T>();

		result.addAll((Collection<? extends T>) listGeneric);

		return result;
	}

}