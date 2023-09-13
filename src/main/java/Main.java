import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UnirestException {
        HashMap<String, String> csrfAndCookie = getCsrfAndCookie();
        String endCookie = getEndCookie(csrfAndCookie);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://atcoder.jp/contests/arc164/submissions?f.User=Rayanx&page=1")
                .header("Cookie", endCookie)
                .asString();

    }

    private static String getEndCookie(HashMap<String,String>map) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://atcoder.jp/login")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", map.get("cookie"))
                .field("username", "Yangjize")
                .field("password", "1092yang")
                .field("csrf_token", map.get("csrf"))
                .asString();
        List<String> strings = response.getHeaders().get("Set-Cookie");
        return strings.get(1);
    }
    private static HashMap<String,String>getCsrfAndCookie() throws UnirestException {
        HashMap<String, String> map = new HashMap<>();
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://atcoder.jp/")
                .asString();
        map.put("csrf",extractCsrfToken(response.getBody()));
        map.put("cookie",response.getHeaders().get("Set-Cookie").get(1));
        return map;
    }
    private static String extractCsrfToken(String javascriptCode) {
        int startIndex = javascriptCode.indexOf("var csrfToken = \"");
        int endIndex = javascriptCode.indexOf("\"", startIndex + "var csrfToken = \"".length());

        if (startIndex != -1 && endIndex != -1) {
            return javascriptCode.substring(startIndex + "var csrfToken = \"".length(), endIndex);
        }

        return null;
    }
}
