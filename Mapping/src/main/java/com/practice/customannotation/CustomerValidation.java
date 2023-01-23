package com.practice.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerValidation implements ConstraintValidator<EvenOrNull, Integer> {

	@Override
	public boolean isValid(Integer custSalary, ConstraintValidatorContext context) {
		if(custSalary == 0 || custSalary % 2 ==0)
		{
			return true;
		}
		return false;
	}
}
