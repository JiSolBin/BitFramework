package com.bit.sts30.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.sts30.domain.LoginUser;
import com.bit.sts30.repository.LoginMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	LoginMapper loginMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser bean = loginMapper.findUser(username);
		return new SecureUser(bean);
	}

}
