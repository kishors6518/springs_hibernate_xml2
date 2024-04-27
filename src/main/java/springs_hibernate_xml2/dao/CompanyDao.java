package springs_hibernate_xml2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import springs_hibernate_xml2.dto.Company;
import springs_hibernate_xml2.dto.Employee;

public class CompanyDao {
	
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}
	
	public void saveEmployee(Company company)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		List<Employee>list=company.getEmp();
		transaction.begin();
//		for (Employee employee : list) {
//			getManager().persist(employee);
//			System.out.println(employee);
//		}
		manager.persist(company);
		transaction.commit();	
	}
	public void getCompany(int id)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Company company=manager.find(Company.class,id);
		if(company!=null)
		{
			System.out.println(company);
		}
		else
		{
			System.out.println("Company not found");
		}
	}
	public void deleteCompany(int id)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Company company=manager.find(Company.class,id);
		if(company!=null)
		{
			List<Employee>list=company.getEmp();
			transaction.begin();
//			for (Employee employee : list) {
//				manager.remove(employee);
//			}
			manager.remove(company);
			transaction.commit();	
		}
		else
		{
			System.out.println("Company not found");
		}
	}
	public void updateCompany(int id,Company company)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Company company2=manager.find(Company.class,id);
		if(company2!=null)
		{
			company.setId(id);
			company.setEmp(company2.getEmp());
			
			transaction.begin();
			manager.merge(company);
			transaction.commit();
		}
		else
		{
			System.out.println("No company found");
		}

	}
	public void updateBoth(int id,Company company)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Company company2=manager.find(Company.class,id);
		if(company2!=null)
		{
			company.setId(id);
			for (int i = 0; i < company2.getEmp().size(); i++) {
				company.getEmp().get(i).setId(company2.getEmp().get(i).getId());			
			}
			transaction.begin();
			for (Employee employee : company.getEmp()) {
				manager.merge(employee);
			}
			manager.merge(company);
			transaction.commit();
		}
		else
		{
			System.out.println("No company found");
		}

	}

}
