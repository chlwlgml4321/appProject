package com.mobile.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mobile.domain.Authority;
import com.mobile.domain.Office;
import com.mobile.repository.OfficeRepository;

@Component
public class STest implements AuthenticationProvider {
	
	
	
	@Autowired
	OfficeRepository officeRepo;

	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private final String[] role = {"ROLE_OFFICE","ROLE_ADMIN"};
	
	/**
	 * 지점 : 0, 수퍼 관리자 1
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		List<SimpleGrantedAuthority> authList = new ArrayList<>(); //권한을 담을 리스트
		
		Office office;
		Object principal=null;
		System.out.println("getName..."+authentication.getName());
		
		String tel = (String)authentication.getPrincipal();//id
		String password = (String)authentication.getCredentials();
		
		//멤버 파트너 분기
		
		office = officeRepo.findByTel(tel);
		System.out.println("size : " + office.getRoles().size());
				
		if(office!=null) {
			if(!office.getPassword().equals(password)) {
				throw new UsernameNotFoundException("정보 확인 바람");  //비번 검증
			}else {//관리자 tel, pwd 일치
				for(Authority auth : office.getRoles()) {
					int idx = Integer.parseInt(auth.getRole());
					String roleName = role[idx];
					System.out.println("role name : " + roleName);
					authList.add(new SimpleGrantedAuthority(roleName));
					principal=office;
				}
			}
		}else { //end member
			System.out.println("로그인 식별자 에러");
			throw new UsernameNotFoundException("정보 확인 바람");  //비번 검증
			
		} //end if

		//throw new UsernameNotFoundException("정보 확인 바람"); //아이디
		return new UsernamePasswordAuthenticationToken(principal, null, authList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
	
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	

	
	

}
