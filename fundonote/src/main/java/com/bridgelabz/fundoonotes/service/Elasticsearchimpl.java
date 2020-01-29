//package com.bridgelabz.fundoonotes.service;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.bridgelab.config.connector.Elasticconfig;
//import com.bridgelabz.fundoonotes.model.Note;
//import com.fasterxml.jackson.databind.ObjectMapper;
//@Service
//public class Elasticsearchimpl implements Elasticsearch{
//	//@Autowired
//	//private Elasticconfig config;
//	@Autowired
//	private ObjectMapper objectmapper;
//	
//	private String INDEX = "springboot";
//	
//	private String TYPE = "note_details";
//
//	@Override
//	public String CreateNote(Note note) {
//		Map<String, Object> notemapper = objectmapper.convertValue(note, Map.class);
//		IndexRequest indexrequest = new IndexRequest(INDEX, TYPE, String.valueOf(note.getUserId())).source(notemapper);
//		IndexResponse indexResponse = null;
//		try {
//			indexResponse = config.client().index(indexrequest, RequestOptions.DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(indexrequest);
//		System.out.println(indexResponse);
//		System.out.println( indexResponse.getResult().name());
//		return indexResponse.getResult().name();
//		
//		
//	}
//
//	@Override
//	public String UpdateNote(Note note) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String DeleteNote(Note note) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Note> searchbytitle(String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//
//	
//	}
//
