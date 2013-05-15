package davenkin;

import com.melt.config.AutoWiredBy;
import com.melt.core.Container;
import com.melt.core.ContainerBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/28/13
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClasspathXmlContainerBuilder {

    private final ContainerBuilder builder = new ContainerBuilder(AutoWiredBy.TYPE);

    public Container build(String classpathXml) {
        InputStream inputStream = this.getClass().getResourceAsStream(classpathXml);

        try {
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(inputStream);

            NodeList beans = document.getDocumentElement().getElementsByTagName("bean");
            for (int index = 0; index < beans.getLength(); index++) {
                builder.register(Class.forName(beans.item(index).getTextContent()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public ClasspathXmlContainerBuilder withParent(Container parent) {
        builder.parent(parent);
        return this;
    }
}
