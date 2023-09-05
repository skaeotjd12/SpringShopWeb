package com.nice.shop.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nice.shop.model.User;

import lombok.Data;

/*		override 할때 컨트롤 쉬프트 s 해서 한 번에 다 만들면됨
 *    스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
 *    스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
*/

@Data 
public class PrincipalDetail implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user; // 콤포지션 객체를 품고있는 것

	public PrincipalDetail(User user) {
		this.user = user;
	}
	@Override
	public String getPassword() {
		return user.getUserPwd();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	//계정이 만료되지 않았는지 리턴한다. (true :만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있지 않았는지 리턴한다. (true : 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호가 만료되지 않았는지 리턴한다. (true : 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//계정이 활성화(사용가능)인지 리턴한다. (true : 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{
			return "ROLE_"+user.getRole(); //ROLE_이건 스프링 규칙이라 꼭 넣어줘야함
		});
		return collectors;
	}
	
}
