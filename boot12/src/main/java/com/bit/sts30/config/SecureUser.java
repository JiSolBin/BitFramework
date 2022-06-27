package com.bit.sts30.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.bit.sts30.domain.LoginUser;

import lombok.Data;

@Data
public class SecureUser extends User {
	
	private LoginUser loginUser;

	public SecureUser(LoginUser bean) {
		super(bean.getUsername(), bean.getPassword(), 
				AuthorityUtils.createAuthorityList(bean.getAuthority()));
		loginUser = bean;
	}

}
