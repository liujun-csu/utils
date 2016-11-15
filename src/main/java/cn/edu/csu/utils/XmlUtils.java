package cn.edu.csu.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public abstract class XmlUtils {
	
	public XmlUtils(){}
	
	
	/**
	 * 对象转XML
	 * @param obj 需要转换的对象
	 * @param map 设置子节点名称
	 * @return
	 */
	public static String toXML(Object obj,Map<String, Class<?>> map){
		XStream xstream = new XStream(new DomDriver());
		if(!map.isEmpty()){
			Set<Entry<String, Class<?>>> set = map.entrySet();
			for (Entry<String, Class<?>> entry : set) {
				xstream.alias(entry.getKey(), entry.getValue());
			}
		}
		return  xstream.toXML(obj);
	}
	
	/**
	 * XML转对象
	 * @param xml XML数据源
	 * @param map 设置子节点名称
	 * @return
	 */
	public static Object fromXML(String xml,Map<String, Class<?>> map){
		XStream xstream = new XStream(new DomDriver());
		//忽略xml空节点
		xstream.ignoreUnknownElements();
        //下面是转换常用的数字类型
		xstream.registerConverter(new DoubleConverter()
            {
                @Override
                public Object fromString(String str) {
                    if (StringUtils.isBlank(str)) {
                        return null;
                    }
                    return super.fromString(str);
                }
            });
		xstream.registerConverter(new LongConverter()
            {
                @Override
                public Object fromString(String str) {
                    if (StringUtils.isBlank(str)) {
                        return null;
                    }
                    return super.fromString(str);
                }
            });
		xstream.registerConverter(new IntConverter()
            {
                @Override
                public Object fromString(String str) {
                    if (StringUtils.isBlank(str)) {
                        return null;
                    }
                    return super.fromString(str);
                }
            });
		if(!map.isEmpty()){
			Set<Entry<String, Class<?>>> set = map.entrySet();
			for (Entry<String, Class<?>> entry : set) {
				xstream.alias(entry.getKey(), entry.getValue());
			}
		}
		return xstream.fromXML(xml);
	}
	
}
