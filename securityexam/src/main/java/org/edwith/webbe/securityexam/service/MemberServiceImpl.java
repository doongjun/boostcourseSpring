package org.edwith.webbe.securityexam.service;

import java.util.ArrayList;
import java.util.List;

import org.edwith.webbe.securityexam.service.security.UserEntity;
import org.edwith.webbe.securityexam.service.security.UserRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public UserEntity getUser(String loginUserId) {
		return new UserEntity("dongjun", "$2a$10$mylS4kmVTQK6mT8LWjVeru6zeihtTvS74HPf0BCQ1Cm0DDpWP9NpS");
	}

	@Override
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<UserRoleEntity> list = new ArrayList<>();
		list.add(new UserRoleEntity("dongjun", "ROLE_USER"));
		return list;
	}

}
