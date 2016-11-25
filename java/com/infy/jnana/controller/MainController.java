package com.infy.jnana.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.infy.jnana.entity.AdminEntity;
import com.infy.jnana.entity.BookmarkEntity;
import com.infy.jnana.entity.LanPathEntity;
import com.infy.jnana.entity.MyFileEntity;
import com.infy.jnana.entity.Star;
import com.infy.jnana.entity.WordCloud;
import com.infy.jnana.service.MainService;

@Controller
public class MainController {
	
	static{
	    System.out.println("Static init MainController");

	}		
	@Autowired
	private MainService mainService;
	

	
	  private Logger logger = Logger.getLogger(MainController.class);
	 

    @RequestMapping(value="/",method = RequestMethod.GET)
    
    public String homepage(){
        return "firstPage";
    }
    
    
    @RequestMapping(value="/getAll",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
	public List<MyFileEntity> getDocDetails(@RequestParam(value="query") String name)  throws Exception {
    	
    	List<MyFileEntity> documentList=new ArrayList<MyFileEntity>();
    	
    	try{
    		
		 documentList=mainService.getData(name);
		
    	}catch(Exception exception){
    		
    		logger.error(exception.getMessage());
    		
    		throw new Exception();
    		
    	}
	
    	return documentList;
		
	}
    
    @RequestMapping(value="/saveRating",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON)
	public @ResponseBody int saveTasks(@RequestBody Star star) throws Exception
	
	{
    	int value=0;
    	
    	try{
    		
		value=mainService.insertData(star);
		
	}
    	catch(Exception exception){
		
		exception.printStackTrace();
		
	}
		return value;
	}
    
    
    @RequestMapping(value="/getWords",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<WordCloud> getWords(){
    	
    	List<WordCloud> clouds=new ArrayList<WordCloud>();
    	try{
    	 clouds=mainService.getWords();
    	}catch( Exception exception){
    		exception.printStackTrace();
    	}
		return clouds;
    	
    }
    
    @RequestMapping(value="/getAdmins",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<AdminEntity> getAdmin(){   
    	
    	 List<AdminEntity> adminEntities=new ArrayList<AdminEntity>();
    	 
    	 try{
    	 adminEntities=mainService.getAdmin();
    	 
    	 }
    	 catch(Exception exception){
    		 
    		 exception.printStackTrace();
    		 
    	 }
		return adminEntities;    	
    	
    }
    
    @RequestMapping(value="/getUsers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
	public List<AdminEntity> getUsers(@RequestParam(value="users") String users){
		
    	List<AdminEntity> documentList=new ArrayList<AdminEntity>();
    	
    	try{
    		
    	documentList=mainService.getUsers(users);
    	
    	}
    	catch(Exception exception){    		
    		exception.printStackTrace();    		
    	}
    	
		return documentList;
	}
    
    @RequestMapping(value="/getLan",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<LanPathEntity> getLanPath(@RequestParam(value="user")String user){
    	
    	List<LanPathEntity> lanPathEntities=new ArrayList<LanPathEntity>();
    	
    	try{
    		
    	lanPathEntities=mainService.getLanPath(user);
    	
    	}catch(Exception exception){
    		
    		exception.printStackTrace();
    		
    	}
		return lanPathEntities;
    }
    
    @RequestMapping(value="/removeLan",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
    public void deleteLan(@RequestParam Map<String,String> requestParams){
    	
    	String user=requestParams.get("userName");
    	String path=requestParams.get("path");
    	try{
    	mainService.deleteLan(user, path);
    	}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
    }
    
    @RequestMapping(value="/saveLan",method=RequestMethod.POST)
  	public @ResponseBody void saveTasks(@RequestBody LanPathEntity entity)
  	{
    	
    	try{
    		mainService.saveLan(entity);
    		
    	}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
  	}
    
    @RequestMapping(value="/openDoc",method=RequestMethod.GET)
    @ResponseBody
    public void openDoc(@RequestParam(value="url")String url){
    	
    	try{
    	mainService.openDoc(url);
    	
    		}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
    }
    
    
    @RequestMapping(value="/saveBookmark",method=RequestMethod.POST)
	public @ResponseBody void saveBookmark(@RequestBody BookmarkEntity bookmarkEntity)
	{
    	try{
		mainService.saveBookmark(bookmarkEntity);
		
    		}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
	}
    
    @RequestMapping(value="/removeBookmark",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
    public void removeBookmark(@RequestParam Map<String,String> requestParams){
    	
    	String user=requestParams.get("user_id");
    	String url=requestParams.get("doc_path");
    	
    	try{
    	mainService.removeBookmark(user, url);
    	
    		}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
    }
    
    @RequestMapping(value="/getBookmarks",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    @ResponseBody
	public List<BookmarkEntity> getBookmarks(@RequestParam(value="user") String user){
    	
    	List<BookmarkEntity> bookmarkEntities=new ArrayList<BookmarkEntity>();
    	
    	try{
    	 bookmarkEntities=mainService.getBookmark(user);
    	 
    		}catch(Exception exception){
    		
    		exception.printStackTrace();
    	}
		return bookmarkEntities;
		
		
		
	}
    
    
    @RequestMapping(value="/getPreview",method=RequestMethod.GET)
    @ResponseBody
	public ResponseEntity<byte[]> getPreview(@RequestParam(value="file") String path) throws IOException{
	
		 Path paths = Paths.get(path);
		 byte[] data = Files.readAllBytes(paths);
		// String  base64String = Base64.encodeBase64URLSafeString(data);
		 //System.out.println(base64String);
    	 File file = new File(path);
    	 String name=file.getName();
    	 String mime=Files.probeContentType( Paths.get(path));
    	 HttpHeaders headers=new HttpHeaders();
    	 headers.setContentType(org.springframework.http.MediaType.parseMediaType(mime));
    	 headers.add("Content-Disposition", "inline;filename=" + name);
    	 headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    	 ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(data,headers, HttpStatus.OK);
    	 
    	 return response;
    	 
	}
    

	
}
