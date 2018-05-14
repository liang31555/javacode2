package cn.mldn.test.junit;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;

public class IEmpServiceTest {
	private static int empno;

	static {
		empno = new Random().nextInt(10000); // 动态生成一个empno的数据
	}

	@Test
	public void testInsert() {
		Emp vo = new Emp();
		vo.setEmpno(empno);
		vo.setEname("啊本");
		vo.setJob("职位");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Emp vo = new Emp();
		vo.setEmpno(9637);
		vo.setEname("陈冠祐");
		vo.setJob("人体");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(9637);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().get(7369));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().list().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testListIntIntStringString() {
		try {
			Map<String, Object> map = ServiceFactory.getIEmpServiceInstance().list(2, 5, "ename", "");
			int count = (Integer) map.get("empCount");
			List<Emp> all = (List<Emp>) map.get("allEmps");
			TestCase.assertTrue(count > 0 && all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
