package com.tutorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zulkarnaen
 */

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//ini adalah function untuk membuat split
	public static String main(String txt, String splitterRegex){
        List<String> values = new ArrayList<String>();
        String[] splitted = txt.split(splitterRegex);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitted.length; ++i)
        {
            if (!values.contains(splitted[i]))
            {
                values.add(splitted[i]);
                sb.append(' ');
                sb.append(splitted[i]);
            }
        }
        return sb.substring(1);
    }   
	
	/**
	 * @author zulkarnaen
	 */
	
    public Main() {
        super();
    }

	/**
	 * @author zulkarnaen
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
				//membuat String name untuk mendapat parameter input pada jsp index
				String name = request.getParameter("input");
				
				//membuat print servlet dengan nama pw
				PrintWriter pw = response.getWriter();
				
		        //membuat split dengan nama output dan name sebagai input di split
				//sehingga 2 kata yang sama akan jadi 1
				//contoh 'zulkarnaen zulkarnaen' akan hanya muncul di output sebagai 'zulkarnaen' saja
		        String[] output = name.split(" \\s+");
		        
		        //input name akan masuk ke main dan di print
		        name = main(name, " ");
		        System.out.println(name);
				
		        //buat atribute untuk hasil ouput name dengan nama nama
		        //nanti dinama akan dikirim ke index.jsp dan akan sebagai outputnya!
				request.setAttribute("nama", name);
				
				//menyambungkan index ke servlet dan di request lagi ke jsp sehingga output tetap di jsp.
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);			    
			    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
