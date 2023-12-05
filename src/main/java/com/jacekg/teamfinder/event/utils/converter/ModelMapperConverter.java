package com.jacekg.teamfinder.event.utils.converter;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ModelMapperConverter implements ModelConverter {
	
	private final ModelMapper modelMapper;
	
	public ModelMapperConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		PropertyMap<Event, EventResponse> eventPropertyMap = new PropertyMap<Event, EventResponse>() {
			@Override
			protected void configure() {
				map().setUsersId(source.getPlayersId());
			}
		};
		
		modelMapper.addMappings(eventPropertyMap);
		
		TypeMap<Venue, VenueResponse> tm = modelMapper.getTypeMap(Venue.class, VenueResponse.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list) {
	        System.out.println("mapping: " + m);
	    }
	}
	
	public EventResponse convertToResponse(Event event) {
        return modelMapper.map(event, EventResponse.class);
	}
}
