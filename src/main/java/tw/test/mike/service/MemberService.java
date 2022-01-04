package tw.test.mike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.MemberRepository;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public MemberBean selectbyId(MemberBean memberBean) {
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());
		
		if(optional.isPresent()) {
			MemberBean result = optional.get();

			return result;
		}
		return null;
	}
	public boolean delete(MemberBean memberBean) {
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());
		if(optional.isPresent()) {
			memberRepository.delete(memberBean);
			return true;
		}
		return false;
	}
	public MemberBean update(MemberBean memberBean) {
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());
		if(optional.isPresent()) {
			return memberRepository.save(memberBean);
		}
		return null;
	}
	public MemberBean create(MemberBean memberBean) {
		return memberRepository.save(memberBean);

	}
}
