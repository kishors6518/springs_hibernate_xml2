package springs_hibernate_xml2.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springs_hibernate_xml2.dao.CompanyDao;
import springs_hibernate_xml2.dto.Company;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("company.xml");
		CompanyDao dao=context.getBean("dao",CompanyDao.class);
		Company company=(Company) context.getBean("com");
		System.out.println(company);
		dao.saveEmployee(company);
		//dao.getCompany(102);
		//dao.updateCompany(101, company);

	}

}
