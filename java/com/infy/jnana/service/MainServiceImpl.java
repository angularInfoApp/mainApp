package com.infy.jnana.service;

import java.awt.Desktop;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.jnana.dao.MainDAO;
import com.infy.jnana.entity.AdminEntity;
import com.infy.jnana.entity.BookmarkEntity;
import com.infy.jnana.entity.LanPathEntity;
import com.infy.jnana.entity.MyFileEntity;
import com.infy.jnana.entity.Star;
import com.infy.jnana.entity.WordCloud;

@Service
public class MainServiceImpl implements MainService {
	
	  private Logger logger = Logger.getLogger(MainServiceImpl.class);
	
	@Autowired
	private MainDAO mainDAO;
		

		@Override
		public List<MyFileEntity> getData(String name) throws Exception {
			MyFileEntity myFileEntity = null;
			List<MyFileEntity> fileEntities = new ArrayList<MyFileEntity>();
			
			try {
			SolrClient solrClient=new HttpSolrClient.Builder("http://localhost:8983/solr/star/").build();
			SolrQuery sq = new SolrQuery();
			sq.setStart(0);
			sq.setRows(1000);
			sq.setHighlight(true);
			sq.setHighlight(true).setHighlightSnippets(2);
			sq.set("hl.alternateField","title");
			sq.set("hl.highlightAlternate","true");
			sq.setParam("hl.fl","content");
			sq.set("hl.maxAnalyzedChars", 25000000); 
			//sq.set("hl.useFastVectorHighlighter", true);
			sq.setHighlightSimplePre("<strong>");
			sq.setHighlightSimplePost("</strong>");
			/*sq.set("mlt", true);
			sq.set("mlt.fl", "content");
			sq.set("mlt.mindf", 10);
			sq.set("mlt.count",10);*/
			//solrClient.commit();
			String key = name;
			sq.setQuery(key);
			List<String> myLabelList = new ArrayList<String>();
			myLabelList.add("id");
			myLabelList.add("title");
			myLabelList.add("author");
			myLabelList.add("url");
			myLabelList.add("content");
			myLabelList.add("dateCal");
			
			/*	query.setStart((pageNum - 1) * numItemsPerPage);
				query.setRows(numItemsPerPage);*/
			String queries=sq.toString();
			System.out.println(queries);
			QueryResponse rsp = solrClient.query(sq);
			System.out.println(rsp);
			SolrDocumentList docs = rsp.getResults();
			ListIterator<SolrDocument> iter = docs.listIterator();
			mainDAO.saveKey(key);
			while (iter.hasNext()) {

				myFileEntity = new MyFileEntity();
				SolrDocument doc = iter.next();
				Map<String, Collection<Object>> values = doc
						.getFieldValuesMap();
				Iterator<String> labels = doc.getFieldNames().iterator();
				while (labels.hasNext()) {
					String Labelkey = labels.next();
					if (myLabelList.contains(Labelkey)) {
						Collection<Object> myValueObject = values.get(Labelkey);

						Iterator myIter = myValueObject.iterator();
						while (myIter.hasNext()) {
							Object obj = myIter.next();
								String myContent = obj.toString();
								 if("id".equalsIgnoreCase(Labelkey)){
									myFileEntity.setId(myContent);
									String updated="";
									String ids=myContent;
									List<String> highlight=rsp.getHighlighting().get(ids).get("content");
									if(highlight!=null){
										if(highlight.size()>1&&highlight.size()<=2){
											String contentFetch=highlight.get(0)+"<br>"+highlight.get(1);
											
											int j=1;
											for(int i=0;i<contentFetch.length()-1;i++){
												//System.out.println(contentFetch.substring(0, 1));
												if(contentFetch.substring(i,j).matches("[^a-zA-Z0-9 ]")||contentFetch.substring(i,j).matches(" ")){
														++j;
												}
												
												else{
													updated=contentFetch.substring(i,contentFetch.length());
													break;
												}
											}
											
											myFileEntity.setHighlightTxt(updated);
										}else{
										String contentFetch=highlight.get(0);
										
										int j=1;
										for(int i=0;i<contentFetch.length()-1;i++){
											if(contentFetch.substring(i,j).matches("[^a-zA-Z0-9 ]")||contentFetch.substring(i,j).matches(" ")){
													++j;
											}
											
											else{
												updated=contentFetch.substring(i,contentFetch.length());
												break;
											}
										}
										
										myFileEntity.setHighlightTxt(updated);
										}
									}
									}
								 else if ("url".equalsIgnoreCase(Labelkey)) {
									String url= myContent;	
									String type=FilenameUtils.getExtension(url);
									File file=new File(url);
									String nameExt=file.getName();
									myFileEntity.setExtName(nameExt);
									double size=file.length();
									double sizeKb=size/1024;
									double finalZize=Math.round(sizeKb*100.0)/100.0;
									String totSize=String.valueOf(finalZize+" kb");
									String user_id="inf@global";
									int docStatus=mainDAO.getStatus(user_id, url);
									myFileEntity.setUrl(myContent);
									myFileEntity.setFileType(type);		
									myFileEntity.setFileSize(totSize);
									myFileEntity.setStatus(docStatus);
								}
								 
								 else if("title".equalsIgnoreCase(Labelkey)){
									 String titles=myContent;									
									 String fullName=FilenameUtils.getBaseName(titles);									 
									 myFileEntity.setFileName(fullName);
									 int avgRatings=mainDAO.find(fullName);
									 int rateCount=mainDAO.getRating(fullName);
									 myFileEntity.setAvgRating(avgRatings);
									 myFileEntity.setRateCount(rateCount);								 
								 }	
								 else if("dateCal".equalsIgnoreCase(Labelkey)){
									 if(myContent.equals("No Date available")){
										 myFileEntity.setDate("");
									 }else{
									 String date=myContent;
									 myFileEntity.setDate(date+" - ");
								 }
								 }
								
								else if("author".equalsIgnoreCase(Labelkey)){
									String authors=myContent;
									
									if(authors==null){
										 String noAuthor="No Author found for the file";
										 myFileEntity.setFileName(noAuthor);
									 }
									else{										
										myFileEntity.setAuthor(myContent);
									}
								}
								
								 else if("content".equalsIgnoreCase(Labelkey)) {
									 int sumCount=0;
									 String contentToLower=myContent.toLowerCase();
									 String textDisp=contentToLower.replace("\n", " ");
									 
									 if(key.startsWith("\"")&&key.endsWith("\"")){
										 String findStr = key.toLowerCase();
										 String newkey=findStr.replace("\"","");
										 int lastIndex = 0;
											int count = 0;
											while(lastIndex != -1){
											    lastIndex = contentToLower.indexOf(newkey,lastIndex);
											    if(lastIndex != -1){
											        count ++;
											        lastIndex += newkey.length();
											    }
											}
											myFileEntity.setCount(count);
									 }else{
										String findStr = key;
										List<Integer> sumWord=new ArrayList<Integer>();
										List<String> items = new ArrayList<String>(Arrays.asList(findStr.split(" ")));
										if(items.size()>1){
											
											items.add(findStr);
										}
										
										
										for(int i=0;i<items.size();i++){
											String indexWord=items.get(i).toLowerCase();
											int lastIndex = 0;
											int count = 0;
											
											while(lastIndex != -1){
											    lastIndex = contentToLower.indexOf(indexWord,lastIndex);
											    if(lastIndex != -1){
											        count ++;
											        lastIndex += indexWord.length();
											    }
											    
											}
											sumWord.add(count);
											

											sumCount = sumWord.stream().mapToInt(Integer::intValue).sum();
											
										
									}
										myFileEntity.setCount(sumCount);
								 }
									
									  
									   myFileEntity.setContent(textDisp);

									}
								}

							}
						}
					fileEntities.add(myFileEntity);
					}
			
			//solrClient.close();
			
				
			} catch (SolrServerException e) {
				logger.error(e.getMessage());
				
				throw new Exception();
			}
			return fileEntities;
			
			
		}
		
		
		@Override
		public int insertData(Star star) {
			
			int value=0;
			
			try{
				
				value=mainDAO.insertData(star);
				
			
			}
			catch(Exception exception){
				
				exception.printStackTrace();
			}
			return value;
			
		}


		@Override
		public List<WordCloud> getWords() {
			
			List<WordCloud> clouds=new ArrayList<WordCloud>();
			try{
			clouds=mainDAO.getWords();
		
			
			}catch(Exception exception){
			logger.error(exception.getMessage());
			return clouds;
			}
			return clouds;
		}


		@Override
		public List<AdminEntity> getAdmin() {
			
			List<AdminEntity> adminEntities=new ArrayList<AdminEntity>();
			
			adminEntities=mainDAO.getAdmin();
			
			return adminEntities;
		}


		@Override
		public List<AdminEntity> getUsers(String users) {
			
			List<AdminEntity> adminEntities=new ArrayList<AdminEntity>();
			
			adminEntities=mainDAO.getUsers(users);
						
			return adminEntities;
		}


		@Override
		public List<LanPathEntity> getLanPath(String user) {
			
			List<LanPathEntity> lanPathEntities=mainDAO.getLanPath(user);	
			
			return lanPathEntities;
		}


		@Override
		public void deleteLan(String user,String path) {
			try {
				
		mainDAO.deleteLan(user, path);
		
			}
			catch(Exception exception){
				
				exception.printStackTrace();
			}
		}


		@Override
		public void saveLan(LanPathEntity entity) {
			
			try{
				
			mainDAO.saveLan(entity);
			}
			catch(Exception exception){
				
				exception.printStackTrace();
			}
		}


		@Override
		public void openDoc(String url) throws NoSuchAlgorithmException, NoSuchPaddingException {
			
			String fullName=FilenameUtils.getBaseName(url);
			System.out.println(fullName);
				mainDAO.icmtDoc(fullName);	
		     File file = new File(url);
		     String ext = FilenameUtils.getExtension(url);
			 try{
				 
				 if(ext.equals("js")||ext.equals("json")||ext.equals("xml")||ext.equals("md")){
					 
					 if (file.exists()) {

	                     Process p = Runtime
	                        .getRuntime()
	                        .exec("C:\\Program Files (x86)\\Notepad++\\notepad++.exe "+file);
	                     p.waitFor();
	                 } else {
	                     System.out.println("File does not exist");
	                 }	
		           
				 }else if(ext.equals("xlsx")||ext.equals("docx")){
						
						        Desktop.getDesktop().open(file);
				 }else{
					
					 if (file.exists()) {

			                Process p = Runtime
			                   .getRuntime()
			                   .exec("rundll32 url.dll,FileProtocolHandler "+file);
			                p.waitFor();

			            } else {

			                System.out.println("File does not exist");

			            }
					 
				 }

		          } catch (Exception ex) {
		            ex.printStackTrace();
		          }
		}


		@Override
		public void saveBookmark(BookmarkEntity bookmarkEntity) {
			
			try{
				
			mainDAO.saveBookmark(bookmarkEntity);
			
			}
			catch(Exception exception){
				
				exception.printStackTrace();
			}
		}


		@Override
		public void removeBookmark(String user_id, String doc_url) {
			try{
				
			mainDAO.removeBookmark(user_id, doc_url);
			
			}
			catch(Exception exception){
				
				exception.printStackTrace();
			}
		}


		@Override
		public List<BookmarkEntity> getBookmark(String user) {
			List<BookmarkEntity> bookmarkEntity=new ArrayList<BookmarkEntity>();
			try{
			bookmarkEntity=mainDAO.getBookmark(user);
			}catch(Exception exception){
				exception.printStackTrace();
			}
			return bookmarkEntity;
		}
		
		

}
