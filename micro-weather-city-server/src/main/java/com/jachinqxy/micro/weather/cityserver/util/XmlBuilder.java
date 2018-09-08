
package com.jachinqxy.micro.weather.cityserver.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML 工具.
 * @since 2018年07月30日
 * @author Jachin
 */
public class XmlBuilder {
	/**
	 * 将XML字符串转换为指定类型的POJO
	 * 
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
		Object xmlObject = null;
		Reader reader = null;

		JAXBContext context = JAXBContext.newInstance(clazz);

		// 进行将Xml转成对象的核心接口
		Unmarshaller unmarshaller = context.createUnmarshaller();

		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);

		if (null != reader) {
			reader.close();
		}

		return xmlObject;
	}
}
