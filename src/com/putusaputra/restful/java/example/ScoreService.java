package com.putusaputra.restful.java.example;

import javax.ws.rs.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Path("/")
public class ScoreService {

	@GET
	@Path("/score/wins")
	@Produces("text/plain")
	public int getWins() {
		return Score.WINS;
	}
	
	@GET
	@Path("/score/losses")
	@Produces("text/plain")
	public int getLosses() {
		return Score.LOSSES;
	}
	
	@GET
	@Path("/score/ties")
	@Produces("text/plain")
	public int getTies() {
		return Score.TIES;
	}
	
	@POST
	@Path("/score/wins")
	@Produces("text/plain")
	public int increaseWins() {
		return Score.WINS++;
	}
	
	@POST
	@Path("/score/ties")
	@Produces("text/plain")
	public int increaseTies() {
		return Score.TIES++;
	}
	
	@POST
	@Path("/score/losses")
	@Produces("text/plain")
	public int increaseLosses() {
		return Score.LOSSES++;
	}
	
	@GET
	@Path("/score")
	@Produces("application/json")
	public String getScore() {
		String result = "";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.createObjectNode();
		((ObjectNode) rootNode).put("wins", Score.WINS);
		((ObjectNode) rootNode).put("losses", Score.LOSSES);
		((ObjectNode) rootNode).put("ties", Score.TIES);
		
		try {
			 result = objectMapper
					 .writerWithDefaultPrettyPrinter()
					 .writeValueAsString(rootNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@PUT
	@Path("/score")
	@Produces("application/json")
	public String update(
			@QueryParam("wins") int wins, 
			@QueryParam("losses") int losses,
			@QueryParam("ties") int ties) {
		String result = "";
		
		Score.WINS = wins;
		Score.LOSSES = losses;
		Score.TIES = ties;
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.createObjectNode();
		((ObjectNode) rootNode).put("wins", Score.WINS);
		((ObjectNode) rootNode).put("losses", Score.LOSSES);
		((ObjectNode) rootNode).put("ties", Score.TIES);
		
		try {
			result = objectMapper
					.writerWithDefaultPrettyPrinter()
					.writeValueAsString(rootNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
