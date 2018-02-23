/*******************************************************************************
 ******************************************************************************/
package maven06.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <P>TODO</P>
 * 
 * @version 1.0
 * @author
 */
public class SpringBeanUtil implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanUtil.applicationContext = applicationContext;
	}

	@Override
	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	 * 
	 * <p>依据beanName 获取Bean对象</p>
	 * 
	 * @param beanName
	 * @return
	 * @author
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 
	 * <p>依据beanName 获取Bean Class</p>
	 * 
	 * @param beanName
	 * @return
	 * @author
	 */
	public static Class<?> getBeanClass(String beanName) {
		return applicationContext.getType(beanName);
	}

	/**
	 * 
	 * <p>依据beanName和Class类型获取bean对象</p>
	 * 
	 * @param beanName
	 * @param clazz
	 * @return
	 * @author
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) {
		return applicationContext.getBean(beanName, clazz);
	}

}
