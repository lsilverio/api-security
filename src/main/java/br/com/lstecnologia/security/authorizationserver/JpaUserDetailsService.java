package br.com.lstecnologia.security.authorizationserver;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.service.user.UserConsultUsernameService;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserConsultUsernameService userConsultUsernameService;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userConsultUsernameService.findByUsername(username);
		return new AuthUser(userModel, getAuthorities(userModel));
	}
	
	private Collection<GrantedAuthority> getAuthorities(UserModel userModel) {
		return userModel.getProfiles().stream()
				.flatMap(profile -> profile.getPermissions().stream())
				.map(permission -> new SimpleGrantedAuthority(permission.getName().toUpperCase()))
				.collect(Collectors.toSet());
	}

}
