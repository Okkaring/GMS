package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberServiceImpl;

public class MemberController {

	public static void main(String[] args) {
		MemberBean member=null;
		MemberBean bean=null;
		
		Butt[] buttons = {Butt.EXIT, Butt.ADD, Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT, Butt.UPDATE, Butt.DEL};
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(null, "MEMBER ADMIN", "SELEC MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1])){
			case EXIT: return;
			case ADD:
				member=new MemberBean();	
				String[] arr=(JOptionPane.showInputDialog("id / pw / ssn / name ")).split("/");
				member.setId(arr[0]);
				member.setPw(arr[1]);
				member.setSsn(arr[2]);
				member.setName(arr[3]);
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().addMember(member));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, "count :"+ MemberServiceImpl.getInstance().countMembers());
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().list());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().findById(JOptionPane.showInputDialog("조회하려는 id를 입력하세요")).toString());
				break flag;
			case FIND_NAME: 
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findByName(JOptionPane.showInputDialog("조회하려는 이름을 입력하세요")));
				break flag;
			case UPDATE: //다시 고쳐보기
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("아이디를 입력해주세요."));
				bean.setPw(JOptionPane.showInputDialog("변경할 비번을 입력하세요"));
				bean.setName(JOptionPane.showInputDialog("변경할 이름을 입력하세요"));
				bean.setSsn(JOptionPane.showInputDialog("변경할 주민번호을 입력하세요"));
				MemberServiceImpl.getInstance().modify(bean);
				JOptionPane.showMessageDialog(null, "비밀번호 변경완료");
				break flag;
			case DEL:
				MemberServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제할 아이디를 입력해주세요"));
				JOptionPane.showMessageDialog(null, "삭제 완료");
				break flag;
			default:
				break;
			}
		}while(true);
	}
}

