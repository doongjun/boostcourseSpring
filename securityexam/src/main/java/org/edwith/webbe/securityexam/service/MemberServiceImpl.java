package org.edwith.webbe.securityexam.service;

import java.util.ArrayList;
import java.util.List;

import org.edwith.webbe.securityexam.dao.MemberDao;
import org.edwith.webbe.securityexam.dao.MemberRoleDao;
import org.edwith.webbe.securityexam.dto.Member;import org.edwith.webbe.securityexam.dto.MemberRole;
import org.edwith.webbe.securityexam.service.security.UserEntity;
import org.edwith.webbe.securityexam.service.security.UserRoleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	private MemberRoleDao memberRoleDao;
	
	public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao) {
		this.memberDao = memberDao;
		this.memberRoleDao = memberRoleDao;
	}

	@Override
	@Transactional
	public UserEntity getUser(String loginUserId) {
		Member member = memberDao.getMemberByEmail(loginUserId);
		return new UserEntity(member.getEmail(), member.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<MemberRole> memberRoles = memberRoleDao.getRolesByEmail(loginUserId);
		List<UserRoleEntity> list = new ArrayList<>();
		
		for(MemberRole memberRole : memberRoles) {
			list.add(new UserRoleEntity(loginUserId, memberRole.getRoleName()));
		}

		return list;
	}

}
