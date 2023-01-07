package com.blog.payloads;
//import jakarta.validation.constraints.Email;

import javax.validation.constraints.*;

//
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto 
{
	private int id;
	
	@NotEmpty
	@Size(min = 3, message ="UserName Should At Least Four Character!!!")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 4,max = 10,message ="Password Should At Least Four and maximum ten Character!!!")
	private String password;
	
	@NotNull
	private String about;
}
