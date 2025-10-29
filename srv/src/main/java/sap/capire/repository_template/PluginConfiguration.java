package sap.capire.repository_template;

import com.sap.cds.services.runtime.CdsRuntimeConfiguration;
import com.sap.cds.services.runtime.CdsRuntimeConfigurer;
import com.sap.cloud.environment.servicebinding.api.DefaultServiceBindingAccessor;
import com.sap.cloud.environment.servicebinding.api.ServiceBinding;

import sap.capire.repository_template.emoji.CloudHandler;
import sap.capire.repository_template.emoji.MockedHandler;

import java.util.List;

public class PluginConfiguration implements CdsRuntimeConfiguration {
    // private static final Logger LOGGER = LoggerFactory.getLogger(PluginConfiguration.class);
    
    @Override
    public void eventHandlers(CdsRuntimeConfigurer configurer) {
        // check if your needed service is enabled
        if (isRunningOnBTP()) {
            // check if service bindings for your service exist
            configurer.eventHandler(new CloudHandler());
        } else {
            configurer.eventHandler(new MockedHandler());
        }
    }

    private boolean isRunningOnBTP() {
        // Since this sample doesn't connect to any Services we just check if we are deployed
        List<ServiceBinding> allServiceBingins = DefaultServiceBindingAccessor.getInstance().getServiceBindings();
        return allServiceBingins.size() > 0;
    }
}
