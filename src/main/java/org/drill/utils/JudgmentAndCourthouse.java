package org.drill.utils;

import java.io.IOException;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class JudgmentAndCourthouse {
	static OkHttpClient OKHTTPCLIENT = new OkHttpClient();

	public static String getInformation(String text, String apiKey, String url) throws IOException {
		String content = "";
		RequestBody body = new FormEncodingBuilder().add("apiKey", apiKey).add("text", text).build();
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = OKHTTPCLIENT.newCall(request).execute();
		if (response.isSuccessful()) {
			content = response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}

		return content;
	}
}