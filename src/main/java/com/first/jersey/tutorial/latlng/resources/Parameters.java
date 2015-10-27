package com.first.jersey.tutorial.latlng.resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/values")
public class Parameters {
	String path="trackmap.bugs3.com"+File.separator+"jsontext.txt";
	
	@GET
	@Path("/{param1}/{param2}")
	public void makeFile(@PathParam("param1")double a,@PathParam("param2")double b){
		File file = new File(path);
			if(file.exists()){
				file.delete();
			}
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			@SuppressWarnings("resource")
			PrintWriter pw=new PrintWriter(fw);
			pw.println("{\"Latitude\":"+a+",\"Longitude\":"+b+"}");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
