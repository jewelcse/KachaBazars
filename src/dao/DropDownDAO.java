package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import model.DeliveryPersonModel;
import model.DistrictModel;
import model.DivisionModel;
import model.UnionModel;
import model.UpazillaModel;





public class DropDownDAO {
	
	public List<DivisionModel> getAllDivisions() {
		
		List<DivisionModel> divisionsModel = new ArrayList<>();
		String query = "from DivisionsModel divisionsModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from DivisionsModel divisionsModel");
		divisionsModel = queryExecuteable.list();
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return divisionsModel;
		
	}
	
	public List<DistrictModel> getAllDistrictsByDivisions(int divisionsId){
		
		List<DistrictModel> districtsModels = new ArrayList<>();
		String query = "from DistrictsModel districts where districts.divisionModelId='"+divisionsId+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);

		districtsModels=queryExecuteable.list();
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return districtsModels;
		
	}

	public List<UpazillaModel> getAllUpazillasByDistricts(int districtsId) {
		List<UpazillaModel> upazillasModels = new ArrayList<>();
		String query = "from UpazillasModel upazillas where upazillas.districtModelId='"+districtsId+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);

		upazillasModels=queryExecuteable.list();
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return upazillasModels;
	}

	public Map<String, String> getAllDistrictsByDivisionsMap(int divisionsId) {
		String query = "from DistrictModel DistrictModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<DistrictModel> districtModels=new ArrayList<>();
		districtModels = queryExecuteable.list();
		
		Map<String, String> options = new HashMap<>();
		java.util.Iterator<DistrictModel> it = districtModels.iterator();

		while (it.hasNext()) {
			Object type = (Object) it.next();

			DistrictModel sub = (DistrictModel) type;
			System.out.println("Name Distrits: "+sub.getDistrictName());
			if (sub.getDivisionModel().getDivisionId() == divisionsId) {
				options.put(String.valueOf(sub.getDistrictId()), sub.getDistrictBanglaName());
			}

		}

		session.flush();
		session.close();
		con.closeSessionFactory();
		return options;
	}

	public Map<String, String> getAllUpazillasByDistrictsMap(int districtsId) {
		String query = "from UpazillaModel UpazillaModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<UpazillaModel> upazillaModels=new ArrayList<>();
		upazillaModels = queryExecuteable.list();

		Map<String, String> options = new HashMap<>();
		java.util.Iterator<UpazillaModel> it = upazillaModels.iterator();

		while (it.hasNext()) {
			Object type = (Object) it.next();

			UpazillaModel sub = (UpazillaModel) type;
			System.out.println("Name Upazillas: "+sub.getUpazillaName() + " " + sub.getDistrictModel().getDistrictId() + " = " + districtsId + " " + sub.getUpazillaName());
			if (sub.getDistrictModel().getDistrictId() == districtsId) {
				options.put(String.valueOf(sub.getUpazillaId()), sub.getUpazillaBangaName());
			}

		}

		session.flush();
		session.close();
		con.closeSessionFactory();
		return options;
	}

	public Map<String, String> getAllUnionsByUpazillasMap(int upazillasId) {
		String query = "from UnionModel UnionModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<UnionModel> unionModels=new ArrayList<>();
		unionModels = queryExecuteable.list();

		Map<String, String> options = new HashMap<>();
		java.util.Iterator<UnionModel> it = unionModels.iterator();

		while (it.hasNext()) {
			Object type = (Object) it.next();

			UnionModel sub = (UnionModel) type;
			
			if (sub.getUpazillaModel().getUpazillaId() == upazillasId) {
				System.out.println("Name Unions: "+sub.getUnionBanglaName()+"Id "+sub.getUpazillaModel().getUpazillaId() + " " + upazillasId);
				options.put(String.valueOf(sub.getUnionId()), sub.getUnionBanglaName());
			}

		}

		session.flush();
		session.close();
		con.closeSessionFactory();
		return options;
	}

	public Map<String, String> getAllDeliveryManByUnionIdMap(int unionId) {
		// TODO Auto-generated method stub
		String query = "from DeliveryPersonModel DeliveryPersonModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<DeliveryPersonModel> deliveryPersonModels=new ArrayList<>();
		deliveryPersonModels = queryExecuteable.list();

		Map<String, String> options = new HashMap<>();
		java.util.Iterator<DeliveryPersonModel> it = deliveryPersonModels.iterator();

		while (it.hasNext()) {
			Object type = (Object) it.next();

			DeliveryPersonModel sub = (DeliveryPersonModel) type;
			
			if (sub.getUnionModel().getUnionId() == unionId) {
				System.out.println("Name delivery: "+sub.getDeliveryPersonFirstName() + " delId : " + sub.getDeliveryPersonId() +" Id "+sub.getUnionModel().getUnionId() + " " + unionId);
				options.put(String.valueOf(sub.getDeliveryPersonId()), sub.getDeliveryPersonFirstName()+ " " + sub.getDeliveryPersonLastName());
			}

		}

		session.flush();
		session.close();
		con.closeSessionFactory();
		return options;
	}

}
