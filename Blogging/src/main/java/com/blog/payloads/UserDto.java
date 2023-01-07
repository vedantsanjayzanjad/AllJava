package com.blog.payloads;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto 
{
	private int id;
	
	@NotNull
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String about;
}
