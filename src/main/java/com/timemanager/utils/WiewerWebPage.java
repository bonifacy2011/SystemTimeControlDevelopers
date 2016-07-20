package com.timemanager.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WiewerWebPage {

	private static List<String> getHTMLFrom(String urlAdress) throws IOException {

		String textFromUrl = "";

		List<String> resultText = new ArrayList<>();

		URL url = new URL(urlAdress);

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

		while ((textFromUrl = br.readLine()) != null) {

			resultText.add(textFromUrl);

		}

		br.close();

		return resultText;

	}

	public static void main(String[] args) throws IOException {

		List<String> siteCode = getHTMLFrom("http://www.tut.by");

		for (String list : siteCode) {

			System.out.println(list);
		}

	}

}
