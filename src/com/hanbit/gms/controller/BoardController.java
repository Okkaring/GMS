package com.hanbit.gms.controller;

import javax.swing.JOptionPane;
import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleServiceImpl;

public class BoardController {
public static void main(String[] args) {
	ArticleBean bean = null;
	Butt[] buttons = {Butt.EXIT, Butt.WRITE, Butt.LIST,Butt.FIND_ID,Butt.FIND_SEQ,Butt.COUNT, Butt.UPDATE, Butt.DEL};
	do{
		flag:
		switch((Butt)JOptionPane.showInputDialog(null, "WRITE CONTENT", "SELEC MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1])){
		case EXIT: return;
		case WRITE:
			bean = new ArticleBean();
			String[] foo = (JOptionPane.showInputDialog("id/ title / content").split("/"));
			bean.setId(foo[0]);
			bean.setTitle(foo[1]);
			bean.setContent(foo[2]);
			JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().write(bean));
			break flag;
		case LIST:
			JOptionPane.showMessageDialog(null, "list : " + ArticleServiceImpl.getInstance().list());
			break flag;
		case FIND_ID:
			JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findByid(JOptionPane.showInputDialog("조회하실 아이디를 입력하세요").toString()));
			break flag;
		case FIND_SEQ: 
			JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findBySeq(JOptionPane.showInputDialog("조회하실 게시글 번호를 입력하세요.")));
			break flag;
		case COUNT:
			JOptionPane.showMessageDialog(null, "count : " + ArticleServiceImpl.getInstance().count());
			break flag;
		case UPDATE:
			String[] bar = (JOptionPane.showInputDialog("article_seq/ title/ content").split("/"));
			bean = new ArticleBean();
			bean.setArticleSeq(Integer.parseInt(bar[0]));
			bean.setTitle(bar[1]);
			bean.setContent(bar[2]);
			JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().modify(bean));
			break flag;
		case DEL:
			JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제할 게시글 번호")));
			break flag;
		default:
			break;
		}
		}while(true);
	}
}
