package com.jacekg.teamfinder.event.utils.converter;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EventModelConverterImpl implements EventModelConverter {
	
	private final ModelMapper modelMapper;

	public EventModelConverterImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@PostConstruct
	public void init() {

	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		PropertyMap<Event, EventResponse> eventPropertyMap = new PropertyMap<Event, EventResponse>() {
			@Override
			protected void configure() {
				map().setVenueId(source.getVenueId());
				map().setLocation(source.getLocation());
				map().setCity(source.getCity());
				map().setStreet(source.getStreet());
				map().setCreatorUserId(source.getCreatorUserId());
				map().setCreatorUsername(source.getCreatorUsername());
				map().setPlayersId(source.getPlayersId());
			}
		};

		modelMapper.addMappings(eventPropertyMap);

		TypeMap<Event, EventResponse> tm = modelMapper.getTypeMap(Event.class, EventResponse.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list) {
	        System.out.println("mapping: " + m);
	    }
	}
	
	public EventResponse convertToResponse(Event event) {
        return modelMapper.map(event, EventResponse.class);
	}
}
