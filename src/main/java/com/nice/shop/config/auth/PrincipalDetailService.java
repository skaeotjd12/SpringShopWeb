package com.nice.shop.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nice.shop.model.User;
import com.nice.shop.repository.UserRepository;


@Service
public class PrincipalDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User principal = userRepository.findByUserId(userId)
				 .orElseThrow(()->{
						return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : "+userId);
					});
		return new PrincipalDetail(principal);
	}
	
}
