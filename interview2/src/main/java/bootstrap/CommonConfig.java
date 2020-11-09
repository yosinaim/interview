package bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan({"api"})
public class CommonConfig {
}
