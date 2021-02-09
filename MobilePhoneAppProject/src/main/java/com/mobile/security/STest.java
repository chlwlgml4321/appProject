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

import com.mobile.domain.Admin;
import com.mobile.domain.Authority;
import com.mobile.domain.Office;
import com.mobile.repository.AdminRepository;
import com.mobile.repository.OfficeRepository;

@Component
public class STest implements AuthenticationProvider {
	
	@Autowired
	AdminRepository adminRepo;
	
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
		Admin admin;
		Office office;
		Object principal=null;
		System.out.println("getName..."+authentication.getName());
		String tel = (String)authentication.getPrincipal();//id
		String pwd = (String)authentication.getCredentials();
		
		//멤버 파트너 분기
		admin = adminRepo.findByTel(tel);
		office = officeRepo.findByTel(tel);
		
		
		if(admin!=null) {
			if(!admin.getPassword().equals(pwd)) {
				throw new UsernameNotFoundException("정보 확인 바람");  //비번 검증
			}else {//관리자 tel, pwd 일치
				for(Authority auth : admin.getRoles()) {
					int idx = Integer.parseInt(auth.getRole());
					String roleName = role[idx];
					authList.add(new SimpleGrantedAuthority(roleName));
					principal=admin;
				}
			}
		}else { //end member
			office = officeRepo.findByTel(tel); //아이디로 파트너 찾기
			if(office!=null) { //id 존재
				if(office.getPassword().equals(pwd)) {//비번도 일치한다면
					for(Authority auth : office.getRoles()) {
						int idx = Integer.parseInt(auth.getRole());
						String roleName = role[idx];
						authList.add(new SimpleGrantedAuthority(roleName));
						principal=office;
					}	
				}else {
					throw new UsernameNotFoundException("정보 확인 바람");  //비번 검증
				}//end if 비번 불일치
			}else{ //partner가 null 이면
				System.out.println("로그인 식별자 에러");
			}//end if	
		} //end if

		//throw new UsernameNotFoundException("정보 확인 바람"); //아이디
		return new UsernamePasswordAuthenticationToken(principal, null, authList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
	
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	

	
	

}
