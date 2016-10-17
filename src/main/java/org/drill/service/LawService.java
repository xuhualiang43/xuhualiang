package org.drill.service;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.drill.dao.LawDao;
import org.drill.model.common.JsonResponse;
import org.drill.model.po.Information;
import org.drill.model.vo.ResultOut;
import org.drill.utils.ExecuteAndDishonesty;
import org.drill.utils.JudgmentAndCourthouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service("lawService")
public class LawService {
	@Autowired
	private LawDao lawDao;

	public String executeService(String idCard) throws IOException {
		final String APIKEY = "6vTGbGWB9lIqgMNnOyAVWkkslB64nvpqseU1ljwPyTLN3pcEYAj83hns";
		final String URL = "http://api.biinfo.cn/biinfoservice/undertaker";
		String content = ExecuteAndDishonesty.getInformation(idCard, APIKEY, URL);

		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
		JsonArray jsonArray = (JsonArray) jsonObject.get("result");
		int length = jsonArray.size();
		if (!(jsonObject.get("resultCode").toString().equals("200"))) {
			return jsonObject.get("message").toString() + jsonObject.get("resultCode").toString();
		} else {
			ResultOut resultOut = new ResultOut();
			ResultOut[] resultlist = new ResultOut[length];
			for (int i = 0; i < length; i++) {
				JsonObject obj = (JsonObject) jsonArray.get(i);
				resultOut.setName(obj.get("NAME").getAsString());
				resultOut.setCardnums(obj.get("CARDNUM").getAsString());
				resultOut.setCase_code(obj.get("CASE_CODE").getAsString());
				resultOut.setCourt_name(obj.get("COURT_NAME").getAsString());
				resultOut.setReg_date(obj.get("REG_DATE").getAsString());
				resultOut.setExec_money(obj.get("EXEC_MONEY").getAsString());
				resultlist[i] = resultOut;
			}
			JsonResponse<ResultOut[]> jsonResponse = new JsonResponse<>();
			jsonResponse.setData(resultlist);
			jsonResponse.setCode(Integer.parseInt(jsonObject.get("resultCode").toString()));
			jsonResponse.setMessage(jsonObject.get("message").toString());

			Gson gson = new Gson();
			JsonObject obj = new JsonObject();
			obj = gson.toJsonTree(jsonResponse).getAsJsonObject();
			return obj.toString();
		}
	}

	public String dishonestyService(String idCard) throws IOException {
		final String APIKEY = "6vTGbGWB9lIqgMNnOyAVWkkslB64nvpqseU1ljwPyTLN3pcEYAj83hns";
		final String URL = "http://api.biinfo.cn/biinfoservice/disruptinfo";
		String content = ExecuteAndDishonesty.getInformation(idCard, APIKEY, URL);
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
		JsonArray jsonArray = (JsonArray) jsonObject.get("result");
		int length = jsonArray.size();
		if (!(jsonObject.get("resultCode").toString().equals("200"))) {
			return jsonObject.get("message").toString() + jsonObject.get("resultCode").toString();
		} else {
			ResultOut resultOut = new ResultOut();
			ResultOut[] resultlist = new ResultOut[length];
			for (int i = 0; i < length; i++) {
				JsonObject obj = (JsonObject) jsonArray.get(i);
				resultOut.setAge(obj.get("AGE").getAsString());
				resultOut.setCardnum(obj.get("CARDNUM").getAsString());
				resultOut.setCase_code(obj.get("CASE_CODE").getAsString());
				resultOut.setCourt_name(obj.get("COURT_NAME").getAsString());
				resultOut.setDisreput_type_name(obj.get("DISREPUT_TYPE_NAME").getAsString());
				resultOut.setGist_cid(obj.get("GIST_CID").getAsString());
				resultOut.setGist_unit(obj.get("GIST_UNIT").getAsString());
				resultOut.setPerformamce(obj.get("PERFORMANCE").getAsString());
				resultOut.setPublish_date(obj.get("PUBLISH_DATE").getAsString());
				resultOut.setReg_date(obj.get("REG_DATE").getAsString());
				resultOut.setSex_name(obj.get("SEX_NAME").getAsString());
				resultlist[i] = resultOut;
			}
			JsonResponse<ResultOut[]> jsonResponse = new JsonResponse<>();
			jsonResponse.setData(resultlist);
			jsonResponse.setCode(Integer.parseInt(jsonObject.get("resultCode").toString()));
			jsonResponse.setMessage(jsonObject.get("message").toString());
			Gson gson = new Gson();
			JsonObject obj = new JsonObject();
			obj = gson.toJsonTree(jsonResponse).getAsJsonObject();
			return obj.toString();
		}
	}

	public String judgmentService(String text) throws IOException {
		final String APIKEY = "6vTGbGWB9lIqgMNnOyAVWkkslB64nvpqseU1ljwPyTLN3pcEYAj83hns";
		final String URL = "http://api.biinfo.cn/biinfoservice/wenshu";
		String content = JudgmentAndCourthouse.getInformation(text, APIKEY, URL);
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
		JsonArray jsonArray = (JsonArray) jsonObject.get("result");
		int length = jsonArray.size();
		if (!(jsonObject.get("resultCode").toString().equals("200"))) {
			return jsonObject.get("message").toString() + jsonObject.get("resultCode").toString();
		} else {
			ResultOut resultOut = new ResultOut();
			ResultOut[] resultlist = new ResultOut[length];
			for (int i = 0; i < length; i++) {
				JsonObject obj = (JsonObject) jsonArray.get(i);
				resultOut.setCasecode(obj.get("CASECODE").getAsString());
				resultOut.setCasetype(obj.get("CASETYPE").getAsString());
				resultOut.setContent(obj.get("CONTENT").getAsString());
				resultOut.setDesc(obj.get("DESC").getAsString());
				resultOut.setJudgedate(obj.get("JUDGEDATE").getAsString());
				resultOut.setJudgeitle(obj.get("JUDGETITLE").getAsString());
				resultlist[i] = resultOut;
			}
			JsonResponse<ResultOut[]> jsonResponse = new JsonResponse<>();
			jsonResponse.setData(resultlist);
			jsonResponse.setCode(Integer.parseInt(jsonObject.get("resultCode").toString()));
			jsonResponse.setMessage(jsonObject.get("message").toString());
			Gson gson = new Gson();
			JsonObject obj = new JsonObject();
			obj = gson.toJsonTree(jsonResponse).getAsJsonObject();
			return obj.toString();
		}
	}

	public String courthouseService(String text) throws IOException {
		final String APIKEY = "6vTGbGWB9lIqgMNnOyAVWkkslB64nvpqseU1ljwPyTLN3pcEYAj83hns";
		final String URL = "http://api.biinfo.cn/biinfoservice/court";

		String content = JudgmentAndCourthouse.getInformation(text, APIKEY, URL);
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
		JsonArray jsonArray = (JsonArray) jsonObject.get("result");
		int length = jsonArray.size();
		if (!(jsonObject.get("resultCode").toString().equals("200"))) {
			return jsonObject.get("message").toString() + jsonObject.get("resultCode").toString();
		} else {
			ResultOut resultOut = new ResultOut();
			ResultOut[] resultlist = new ResultOut[length];
			for (int i = 0; i < length; i++) {
				JsonObject obj = (JsonObject) jsonArray.get(i);
				resultOut.setFct_class(obj.get("FCT_CLASS").getAsString());
				resultOut.setFct_ggdate(obj.get("FCT_GGDATE").getAsString());
				resultOut.setFct_ggpersonf(obj.get("FCT_GGPERSON").getAsString());
				resultOut.setFct_party(obj.get("FCT_PARTY").getAsString());
				resultOut.setFtc_executiondoc(obj.get("FCT_EXECUTIONDOC").getAsString());
				resultlist[i] = resultOut;
			}
			JsonResponse<ResultOut[]> jsonResponse = new JsonResponse<>();
			jsonResponse.setData(resultlist);
			jsonResponse.setCode(Integer.parseInt(jsonObject.get("resultCode").toString()));
			jsonResponse.setMessage(jsonObject.get("message").toString());
			Gson gson = new Gson();
			JsonObject obj = new JsonObject();
			obj = gson.toJsonTree(jsonResponse).getAsJsonObject();
			return obj.toString();
		}
	}
 
	public int selectUsers(String username, String password) {

		return lawDao.selectUsers(username, password);

	}
	
	public void save(String idCard){
		Format format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String dataTime = format.format(new Date());
		Information information = new Information();
		information.setInformation("time:" + dataTime + " idCard:" + idCard);
		lawDao.save(information);
	}
}
