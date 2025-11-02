package sap.capire.repository_template;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.sap.cds.Result;
import com.sap.cds.reflect.CdsElement;
import com.sap.cds.reflect.CdsStructuredType;
import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

@ServiceName(value = "*", type = ApplicationService.class)
public class EmojiHandler implements EventHandler {
	
	private static final String EMOJI_ANNOTATION_NAME = "@emoji";

	@After(event = CqnService.EVENT_READ)
	public void decorateEmoji(CdsReadEventContext ctx) {

		ctx.getResult().list().forEach(row -> {
			Set<String> emojiAnnotatedElments = checkForEmojiAnnotatedElments(ctx.getResult());
			row.keySet().forEach(key -> {
				if(emojiAnnotatedElments.contains(key)) {
					row.put(key, row.get(key) + " 🙃");
				}
			});
		}
		);
	}

	private Set<String> checkForEmojiAnnotatedElments(Result result) {
		Set<String> annotatedElementNames = new HashSet<>();
		CdsStructuredType rowType = result.rowType();//.annotations().anyMatch(anno -> anno.getName().equals("@emoji"))) 
		for(CdsElement element : rowType.elements().collect(Collectors.toList())) {
			if(element.findAnnotation(EMOJI_ANNOTATION_NAME).isPresent()) {
				annotatedElementNames.add(element.getName());
			}
		}
		return annotatedElementNames;
	}
}