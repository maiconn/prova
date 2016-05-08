package br.com.hbsis.prova.util;

public final class ConfigUtils {
	public static final String URL_PREVISAO = "http://openweathermap.org/api";
	public static final String PREVISAO_TOKEN = "eb8b1a9405e659b2ffc78f0a520b1a46";	
	
	public static String getUrlCidade(String cidade){
		return String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cidade, PREVISAO_TOKEN);
	}
	
	public static String getUrlForecast(String cidade){
		return String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&mode=json&units=metric&&appid=%s", cidade, PREVISAO_TOKEN);
	}
}
