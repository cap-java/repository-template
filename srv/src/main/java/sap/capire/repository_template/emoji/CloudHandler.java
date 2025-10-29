package sap.capire.repository_template.emoji;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.handler.annotations.ServiceName;

@Component
@ServiceName(value = "*", type=ApplicationService.class)
public class CloudHandler {
    private static String[] emojis = {"😇", "😍"};
    Random random = new Random();

    public CloudHandler() {}

    public String getRandomEmoji() {
        return emojis[random.nextInt(emojis.length)];
    }
}
