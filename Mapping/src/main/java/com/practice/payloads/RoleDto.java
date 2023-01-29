package com.practice.payloads;

import java.util.HashSet;
import java.util.Set;

import com.practice.model.Orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
	
		private int id;
		private String name;
	
}
