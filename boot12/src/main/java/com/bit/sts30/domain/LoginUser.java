package com.bit.sts30.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {

	private String username;
	private String password;
	private int enabled;
	private String authority;
}
