package by.alpha.config.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class WebDriverScope extends SimpleThreadScope {

    @Override
    public Object get(final String name,final ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        SessionId id = ((RemoteWebDriver)o).getSessionId();
        if (Objects.isNull(id)) {
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }
}
