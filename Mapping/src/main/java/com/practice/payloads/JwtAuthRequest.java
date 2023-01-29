package com.practice.payloads;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
public class JwtAuthRequest {

	private String username;
	
	private String password;
}
