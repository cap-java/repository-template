package sap.capire.repository_template;

import com.sap.cds.services.runtime.CdsRuntimeConfiguration;
import com.sap.cds.services.runtime.CdsRuntimeConfigurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmojiHandlerRuntimeConfiguration implements CdsRuntimeConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(EmojiHandlerRuntimeConfiguration.class);

	@Override
	public void eventHandlers(CdsRuntimeConfigurer configurer) {
		
		configurer.eventHandler(new EmojiHandler());
		logger.info("Registered EmojiHandler event handler.");
	}
	
}