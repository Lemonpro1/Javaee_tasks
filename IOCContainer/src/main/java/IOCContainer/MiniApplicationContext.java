package IOCContainer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniApplicationContext {
    //存放创建的bean
    private Map<String, Object> beans = new HashMap<>();

    public MiniApplicationContext(String xmlPath) {
        loadBeans(xmlPath);
        injectDependencies();
    }
//根据名称获取bean
    public Object getBean(String name) {
        return beans.get(name);
    }

    private void loadBeans(String xmlPath) {
        try {
            SAXReader reader = new SAXReader();
            InputStream is = getClass().getClassLoader().getResourceAsStream(xmlPath);
            Document document = reader.read(is);

            Element root = document.getRootElement();
            List<Element> beanElements = root.elements("bean");

            for (Element beanElement : beanElements) {
                String id = beanElement.attributeValue("id");
                String className = beanElement.attributeValue("class");

                Class<?> clazz = Class.forName(className);
                Object bean = clazz.newInstance();

                beans.put(id, bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void injectDependencies() {
        for (Object bean : beans.values()) {
            Class<?> clazz = bean.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    String fieldName = field.getName();
                    Object dependency = beans.get(fieldName);

                    if (dependency != null) {
                        field.setAccessible(true);
                        try {
                            field.set(bean, dependency);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
