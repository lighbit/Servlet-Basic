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
 * 
 * @author zulkarnaen
 *
 */

@WebServlet("/Main2")
public class Main2 extends HttpServlet {
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
	public String s;
       
    /**
     * @author zulkarnaen
     */
	
    public Main2() {
        super();
    }

	/**
	 * @author zulkarnaen
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//membuat String name untuk mendapat parameter input pada jsp index
				String name = request.getParameter("input");
				
				//membuat tanggal
				Date today = new Date();
			 	SimpleDateFormat date = new SimpleDateFormat("dd MMMMMMMMMM yyyy");
			 	String dates = date.format(today);
				
			 	//membuat print servlet dengan nama pw
				PrintWriter pw = response.getWriter();
				
				//contoh input dibawah ini
		        //s = "Saya sudah datang tiga kali. kali kali Angke sudah banjir dari malam malam hari. Sejak malam-malam kemarin selalu hujan";
				
				//membuat split dengan nama output dan name sebagai input di split
				//sehingga 2 kata yang sama akan jadi 1
				//contoh 'zulkarnaen zulkarnaen' akan hanya muncul di output sebagai 'zulkarnaen' saja
		        String[] output = name.split(" \\s+");
		       
		        //hasil inputan output dimasukan kedalam ArrayList
		        System.out.println(Arrays.asList(output));
		        
		        //input name akan masuk ke main dan di print
		        name = main(name, " ");
		        System.out.println(name);
				
		        ///buat atribute untuk hasil ouput name dengan nama nama
		        //nanti dinama akan dikirim ke index.jsp dan akan sebagai outputnya!
				request.setAttribute("nama", name);
			    
				//buat tampilan html dengan Servlet
			    pw.print("<body>");
			    pw.print("<h1><font size='7' face='Georgia, Arial' color='maroon'>T</font>ABLE</h1>");
			    pw.print("<hr>");
			    pw.print("<table border='1' cellpadding='24' cellspacing='3'>");
			    pw.print("<tbody><tr bgcolor='silver'>");
			    pw.print("<td><center>NO</center></td>");
			    pw.print("<td><center>Input</center></td>");
			    pw.print("<td><center>Output</center></td>");
			    pw.print("<td><center>Tanggal</center></td></tr>");
			    pw.print("<tr><td>1</td>");
			    
			    //memanggil output ArrayList untuk dijadikan input
			    pw.print("<td>" + Arrays.asList(output) + "</td>");
			    
			    //memanggil output dari split name untuk dijadikan output
			    pw.print("<td>" + name + "</td>");
			    
			    //memanggil tanggal
			    pw.print("<td>" + dates +"</td></tr>");
			    pw.print("</tr></tbody></table>");
			    pw.print("</form></body></html>");
			    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
