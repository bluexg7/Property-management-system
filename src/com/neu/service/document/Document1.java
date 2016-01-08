package com.neu.service.document;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Document1_Info;
import com.neu.dao.Document1_DAO;

public class Document1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
		   this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		
		int doc_num=0;
		if(!session.getAttribute("doc_num").toString().isEmpty())
			doc_num=Integer.parseInt((String)session.getAttribute("doc_num"));              //编号
		String doc_title = (String) session.getAttribute("doc_title");           //名称
		String start_time= (String) session.getAttribute("start_time"); 
		String end_time= (String) session.getAttribute("end_time");             
		String upload_person= (String) session.getAttribute("upload_person"); 
		Document1_DAO d1_dao = new  Document1_DAO();
		List<Document1_Info> resultList = d1_dao.select(doc_num,doc_title,start_time,end_time,upload_person);
		

		/*****分页处理******/
		//设置要查询的页号
		int currentPage = (Integer)session.getAttribute("currentPage");
		if(request.getParameter("jump_type").equals("first")){
			currentPage = 1;
		}
		else if(request.getParameter("jump_type").equals("back")){
			if(((Integer)session.getAttribute("currentPage")).intValue()>=2)
				currentPage = ((Integer)session.getAttribute("currentPage")).intValue()-1;
		}
		else if(request.getParameter("jump_type").equals("next")){
			 if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)))
				currentPage =((Integer)session.getAttribute("currentPage")).intValue()+1;
		}
		else if(request.getParameter("jump_type").equals("last")){
			currentPage = ((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0));
		}
		else{
			currentPage = Integer.parseInt(request.getParameter("to_page"));
			System.out.println("page" + currentPage);
		}
		session.setAttribute("currentPage",currentPage);
		
		//查询的记录总条数
		session.setAttribute("pageCount",resultList.size());
		//查询结果的一页
		List<Document1_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
	    System.out.println("共查到文档记录"+list.size()+"条");
	    System.out.println("********************************");
        request.setAttribute("doc_list", list);
        
		request.getRequestDispatcher("../document/document1.jsp").forward(request,response);
		
	}

}
