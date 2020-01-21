package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DropDownDAO;
import model.DistrictModel;
import model.UpazillaModel;


public class DropDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello World...");
		RequestDispatcher rd = null;
		int divisionsId = 0;
		DropDownDAO db = new DropDownDAO();
		List<DistrictModel> listOfDistrictsModel = null;
		List<UpazillaModel> listOfUpazillasModel = null;
		String action = request.getParameter("action");

		if (action.equals("divisions")) {
			divisionsId = Integer.parseInt(request.getParameter("divisionsId"));

			Map<String, String> options = db.getAllDistrictsByDivisionsMap(divisionsId);

			
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();

			String json = new Gson().toJson(options);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		}

		else if (action.equals("districts")) {

			int districtsId = Integer.parseInt(request.getParameter("districtId"));
			/*
			 * System.out.println("Hello From AJAX: "+divisionsId);
			 * listOfDistrictsModel=db.getAllDistrictsByDivisions(divisionsId);
			 * request.setAttribute("divisionsId", divisionsId);
			 * request.setAttribute("listOfDistrictsModel", listOfDistrictsModel);
			 * rd=request.getRequestDispatcher("testdropdown.jsp");
			 */
			Map<String, String> options = db.getAllUpazillasByDistrictsMap(districtsId);
			// Map<String, String> options = optionDAO.getAllDeliveryPersonId(id);

//				   Map<String, String> options = new HashMap<>();
//				   options.put("1", "Test");
//				   options.put("2", "Two");
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();

			String json = new Gson().toJson(options);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			/*
			 * //divisionsId=Integer.parseInt(request.getParameter("divisionsId")); Integer
			 * districtsId=Integer.parseInt(request.getParameter("districtsId"));
			 * listOfUpazillasModel=db.getAllUpazillasByDistricts(districtsId);
			 * request.setAttribute("divisionsId", divisionsId);
			 * request.setAttribute("districtsId", districtsId);
			 * request.setAttribute("listOfUpazillasModel", listOfUpazillasModel);
			 * 
			 * System.out.println("List of Upazilla: "+listOfUpazillasModel);
			 * rd=request.getRequestDispatcher("testdropdown.jsp");
			 */
		}

		else if (action.equals("upazillas")) {

			int upazillasId = Integer.parseInt(request.getParameter("upazillasId"));

			Map<String, String> options = db.getAllUnionsByUpazillasMap(upazillasId);

			Gson gson = new GsonBuilder().disableHtmlEscaping().create();

			String json = new Gson().toJson(options);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		}
		else if (action.equalsIgnoreCase("unions")) {
			int upazillasId = Integer.parseInt(request.getParameter("upazillasId"));

			Map<String, String> options = db.getAllUnionsByUpazillasMap(upazillasId);

			Gson gson = new GsonBuilder().disableHtmlEscaping().create();

			String json = new Gson().toJson(options);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		else if (action.equals("delivery")) {
			int unionId = Integer.parseInt(request.getParameter("unionId"));

			Map<String, String> options = db.getAllDeliveryManByUnionIdMap(unionId);

			Gson gson = new GsonBuilder().disableHtmlEscaping().create();

			String json = new Gson().toJson(options);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
