package me.fabiomaffioletti;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Converts properties files to objects and registers them as resolvable dependencies.
 * See ConfigurationPropertiesBindingPostProcessor for the deprecated implementation.
 *
 */
public class ApplicationPropertiesBindingPostProcessor implements BeanFactoryAware, ApplicationContextAware, ResourceLoaderAware, EnvironmentAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    private Environment environment = new StandardEnvironment();

    @PostConstruct
    public void init() throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, BindException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ApplicationProperties.class);

        for (String beanName : beansWithAnnotation.keySet()) {
            Class<?> clazz = beansWithAnnotation.get(beanName).getClass();
            Object newInstance = bindPropertiesToTarget(clazz);

            ConfigurableListableBeanFactory configurableListableBeanFactory = (ConfigurableListableBeanFactory) beanFactory;
            configurableListableBeanFactory.registerResolvableDependency(clazz, newInstance);
        }

    }

    private Object bindPropertiesToTarget(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, BindException {
        ApplicationProperties applicationProperties = clazz.getAnnotation(ApplicationProperties.class);

        Constructor<?> constructor = clazz.getConstructor();
        Object newInstance = constructor.newInstance();

        PropertiesConfigurationFactory<Object> factory = new PropertiesConfigurationFactory<>(newInstance);
        factory.setPropertySources(loadPropertySources(applicationProperties.locations()));
        factory.setConversionService(new DefaultConversionService());
        if (StringUtils.hasLength(applicationProperties.prefix())) {
            factory.setTargetName(applicationProperties.prefix());
        }
        try {
            factory.bindPropertiesToTarget();
        } catch (Exception ex) {
            String targetClass = ClassUtils.getShortName(clazz);
            throw new BeanCreationException(clazz.getSimpleName(), "Could not bind properties to " + targetClass + " (" + applicationProperties.toString() + ")", ex);
        }
        return newInstance;
    }

    private PropertySources loadPropertySources(String[] locations) {
        try {
            PropertySourcesLoader loader = new PropertySourcesLoader();
            for (String location : locations) {
                Resource resource = this.resourceLoader.getResource(this.environment.resolvePlaceholders(location));
                String[] profiles = this.environment.getActiveProfiles();
                for (int i = profiles.length; i-- > 0;) {
                    String profile = profiles[i];
                    loader.load(resource, profile);
                }
                loader.load(resource);
            }
            return loader.getPropertySources();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
